package com.example.demo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ViewController {
    
    @GetMapping("/index")
    public String index(){
        return "index";
    }
}
