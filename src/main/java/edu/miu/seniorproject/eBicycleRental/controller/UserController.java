package edu.miu.seniorproject.eBicycleRental.controller;

import java.util.List;

import javax.validation.Valid;

import edu.miu.seniorproject.eBicycleRental.model.Credential;
import edu.miu.seniorproject.eBicycleRental.model.User;
import edu.miu.seniorproject.eBicycleRental.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/ebicyclerental/user/users")
    public ModelAndView manageCategories() {
        ModelAndView modelAndView = new ModelAndView();
        List<User> users = userService.findAll();
        modelAndView.addObject("users", users);
        modelAndView.setViewName("user/users/users");
        return modelAndView;
    }

    @PostMapping(value = "/ebicyclerental/user/users/add/save")
    public String addNewUser(@Valid @ModelAttribute("user") User user,
                             BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "user/users/newcategoryform";
        }
        user = userService.save(user);
        return "redirect:/ebicyclerental/user/users";
    }

    @GetMapping(value = "/ebicyclerental/user/users/edit/{userId}")
    public String editUserForm(@PathVariable("userId") Long userId, Model model) {
        User user = userService.findById(userId);
        if (user != null) {
            model.addAttribute("user", user);
            return "user/users/edituserform";
        }
        return "user/users/users";
    }

    @GetMapping(value="/ebicyclerental/user/users/delete/{userId}")
    public String deleteUser(@PathVariable("userId") Long id, Model model){
        userService.delete(id);
        return "redirect:/ebicyclerental/user/users";
    }


    @GetMapping("/ebicyclerental/user/users/register")
    public String showRegistrationForm(Model model) {
        User user = new User();
        user.setCredential(new Credential());

        model.addAttribute("user", user);

        return "public/home/signup_form";
    }

    @PostMapping("/ebicyclerental/user/users/process_register")
    public String processRegister(@Valid @ModelAttribute("user") User user,  BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {

            model.addAttribute("errors", bindingResult.getAllErrors());
            return "redirect:/ebicyclerental/user/users/register";
        }
        try{
            userService.save(user);
        }catch (Exception e){
            model.addAttribute("error", bindingResult.getAllErrors());
            model.addAttribute("user", user);
            System.out.println("error++"+e.getMessage());

            return "public/home/signup_form";
        }
        return "redirect:/ebicyclerental/public/home/login";
    }
}