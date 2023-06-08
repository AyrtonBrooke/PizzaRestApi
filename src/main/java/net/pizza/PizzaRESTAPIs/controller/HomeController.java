package net.pizza.PizzaRESTAPIs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.lang.constant.Constable;

@Controller
public class HomeController {

    @GetMapping({"/","/api/login"})
    public String loginPage(){
        return "login";
    }
}