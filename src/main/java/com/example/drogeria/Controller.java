package com.example.drogeria;


import org.springframework.web.bind.annotation.GetMapping;

@org.springframework.stereotype.Controller
public class Controller {


    @GetMapping("/")
    public String app() {
        return "index.html";
    }

    @GetMapping("/naszeLakiery")
    public String lakiery() {
        return "lakiery.html";
    }

    @GetMapping("/naszeZele")
    public String zele() {
        return "zele.html";
    }

    @GetMapping("/naszeAkcesoria")
    public String akcesoria() {
        return "akcesoria.html";
    }

    @GetMapping("/back")
    public String back(){
        return "index.html";
    }
}
