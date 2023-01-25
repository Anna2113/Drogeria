package com.example.drogeria;


import org.springframework.web.bind.annotation.GetMapping;

@org.springframework.stereotype.Controller
public class Controller {


    @GetMapping("/")
    public String app(){
        return "index.html";
    }
}
