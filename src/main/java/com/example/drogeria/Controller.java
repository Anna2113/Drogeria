package com.example.drogeria;


import com.example.drogeria.entity.Product;
import com.example.drogeria.entity.ShoopingCart;
import com.example.drogeria.entity.ShoopingCartItem;
import com.example.drogeria.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.NoSuchElementException;

@org.springframework.stereotype.Controller
public class Controller {

    @Autowired
    private ProductService productService;

    private ShoopingCart shoopingCart = new ShoopingCart();

    @GetMapping("/")
    public String app(Model model) {
        model.addAttribute("shoopingCart", shoopingCart);
        return "index.html";
    }

    @GetMapping("/naszeLakiery")
    public String lakiery(Model model) {
        model.addAttribute("shoopingCart", shoopingCart);
        return "lakiery.html";
    }

    @GetMapping("/naszeZele")
    public String zele(Model model) {
        model.addAttribute("shoopingCart", shoopingCart);
        return "zele.html";
    }

    @GetMapping("/naszeAkcesoria")
    public String akcesoria(Model model) {
        model.addAttribute("shoopingCart", shoopingCart);
        return "akcesoria.html";
    }

    @GetMapping("/back")
    public String back(Model model){
        model.addAttribute("shoopingCart", shoopingCart);
        return "index.html";
    }

    @GetMapping("/addLakier/{id}")
    public String addLakier(Model model, @PathVariable("id") Long id){
        Product product = productService.findProductById(id)
                .orElseThrow(() -> {throw new NoSuchElementException("Nie znaleziono produktu");});
        ShoopingCartItem item = new ShoopingCartItem(product);
        shoopingCart.getItems().add(item);
        model.addAttribute("shoopingCart", shoopingCart);
        return "lakiery.html";
    }


}
