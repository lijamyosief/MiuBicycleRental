package edu.miu.seniorproject.eBicycleRental.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminHomePageController {
    @GetMapping(value = "/ebicyclerental/admin/home")
    public String adminHomePage() {
        return "admin/home";
    }

//    @GetMapping(value = "/ecarrental/page/underconstruction")
//    public String underConstruction() {
//        return "general/underconstruction";
//    }
}
