package edu.miu.seniorproject.eBicycleRental.controller;

import java.util.List;
import javax.validation.Valid;

import edu.miu.seniorproject.eBicycleRental.model.Category;
import edu.miu.seniorproject.eBicycleRental.model.Vehicle;
import edu.miu.seniorproject.eBicycleRental.service.CategoryService;
import edu.miu.seniorproject.eBicycleRental.service.VehicleService;

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
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping(value = "/ebicyclerental/admin/vehicleslist")
    public ModelAndView manageVehicles() {
        ModelAndView modelAndView = new ModelAndView();
        List<Vehicle> vehicles = vehicleService.findAll();
        modelAndView.addObject("vehicles", vehicles);
        modelAndView.setViewName("secured/admin/vehicles/vehicleslist");
        return modelAndView;
    }

    @GetMapping(value = "/ebicyclerental/admin/vehicles/add")
    public String newVehicleForm(Model model) {
        Vehicle newVehicle = new Vehicle();
        newVehicle.setVehicleNumber(vehicleService.assignVehicleNumber());
        List<Category> categories = categoryService.findAll();
        model.addAttribute("vehicle", newVehicle);
        model.addAttribute("categories", categories);
        return "secured/admin/vehicles/newvehicle";
    }

    @PostMapping(value = "/ebicyclerental/admin/vehicles/add/save")
    public String addNewVehicle(@Valid @ModelAttribute("vehicle") Vehicle vehicle,
                                BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "secured/admin/vehicles/newvehicle";
        }
        vehicle = vehicleService.save(vehicle);
        return "redirect:/ebicyclerental/admin/vehicleslist";
    }

    @GetMapping(value = "/ebicyclerental/admin/vehicles/edit/{vehicleId}")
    public String editVehicleForm(@PathVariable("vehicleId") Long vehicleId, Model model) {
        Vehicle vehicle = vehicleService.findById(vehicleId);
        List<Category> categories = categoryService.findAll();
        if (vehicle != null) {
            model.addAttribute("vehicle", vehicle);
            model.addAttribute("categories", categories);
            return "secured/admin/vehicles/editvehicle";
        }
        return "secured/admin/vehicles/vehicleslist";
    }

    @GetMapping(value="/ebicyclerental/admin/vehicles/delete/{vehicleId}")
    public String deleteVehicle(@PathVariable("vehicleId") Long vehicleId){
        System.out.println("vehicle Id before+++"+vehicleId);
        vehicleService.delete(vehicleId);
        System.out.println("vehicle Id after+++"+vehicleId);


        return "redirect:/ebicyclerental/admin/vehicleslist";
    }

}