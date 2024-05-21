package com.binarying.binproject.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {
    
    @GetMapping("/doc")
    public String getDoc() {
        return "documentation/index.html";
    }
}
