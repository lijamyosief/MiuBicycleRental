package edu.miu.seniorproject.eBicycleRental.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import edu.miu.seniorproject.eBicycleRental.service.RoleService;

@Controller
public class RoleController {

    @Autowired
    private RoleService roleService;
}
