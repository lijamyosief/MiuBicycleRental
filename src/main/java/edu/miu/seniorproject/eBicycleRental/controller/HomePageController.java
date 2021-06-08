package edu.miu.seniorproject.eBicycleRental.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomePageController {

    @GetMapping("/test")
    @ResponseBody
    public String testPage(){
        return "Welcome to ebicycle rental website!";
    }

    @GetMapping(value = {"/","/ebicyclerental","/public/home","ebicyclerental/public/home"})
    public String home0() {
        return "public/home/homeindex";
    }

    @GetMapping(value = {"/ebicyclerental/public/customerhome"})
    public String home1() {
        return "public/home/index";
    }

    @GetMapping(value = {"/secured/service","/ebicyclerental/secured/service"})
    public String service() {
        return "secured/services";
    }

    @GetMapping(value = {"/secured/home","/ebicyclerental/secured/home"})
    public String home2() {
        return "secured/index";
    }

    @GetMapping(value = {"/public/home/about","/ebicyclerental/public/home/about"})
    public String about() {
        return "public/home/about";
    }


    @GetMapping(value = {"/public/home/contact","/ebicyclerental/public/home/contact"})
    public String contact() {
        return "public/home/contact";
    }

    @GetMapping(value = {"/public/home/logout","/ebicyclerental/public/home/logout"})
    public String logOut() {
        return "public/home/login";
    }

//    @GetMapping(value = {"/public/virtualtour","/ebicyclerental/public/virtualtour"})
//    public String virtualtour() {
//        return "public/virtualtour";
//    }
//
//    @GetMapping(value = {"/secured/home","/ebicyclerental/secured/home"})
//    public String home2() {
//        return "secured/index";
//    }
}
