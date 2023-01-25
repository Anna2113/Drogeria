package com.example.drogeria;


import org.springframework.web.bind.annotation.GetMapping;

@org.springframework.stereotype.Controller
public class Controller {


    @GetMapping("/")
    public String app(){
        return "index.html";
    }

    @GetMapping("/naszeLakiery")
    public String lakiery(){
        return "lakiery.html";
    }

    @GetMapping("/naszeZele")
    public String zele(){
        return "zele.html";
    }
    @GetMapping("/naszeAkryle")
    public String akryle(){
        return "akryle.html";
    }
}
