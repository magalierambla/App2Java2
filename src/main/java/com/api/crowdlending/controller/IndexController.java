package com.api.crowdlending.controller;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://ec2-3-138-196-167.us-east-2.compute.amazonaws.com:4200")
@RestController
@RequestMapping("/")
public class IndexController {

    @GetMapping
    public String sayHello() {
        return "LEND ME application";
    }
}
