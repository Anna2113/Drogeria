package com.example.drogeria;


import com.example.drogeria.dto.OrderDto;
import com.example.drogeria.dto.ProductDto;
import com.example.drogeria.entity.*;
import com.example.drogeria.exeption.ToMuchException;
import com.example.drogeria.mapper.OrderMapper;
import com.example.drogeria.service.OrderService;
import com.example.drogeria.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.NoSuchElementException;

@org.springframework.stereotype.Controller
public class Controller {

    @Autowired
    private ProductService productService;

    @Autowired
    private OrderService orderService;

    private ShoopingCart shoopingCart = new ShoopingCart();

    private OrderMapper orderMapper = new OrderMapper();

    @GetMapping("/")
    public String app(Model model) {
        model.addAttribute("shoopingCart", shoopingCart);
        return "index.html";
    }

    @GetMapping("/naszeLakiery")
    public String lakiery(Model model) {
        model.addAttribute("shoopingCart", shoopingCart);
        model.addAttribute(new ProductDto());
        return "lakiery.html";
    }

    @GetMapping("/naszeZele")
    public String zele(Model model) {
        model.addAttribute("shoopingCart", shoopingCart);
        model.addAttribute(new ProductDto());
        return "zele.html";
    }

    @GetMapping("/naszeAkcesoria")
    public String akcesoria(Model model) {
        model.addAttribute("shoopingCart", shoopingCart);
        model.addAttribute(new ProductDto());
        return "akcesoria.html";
    }

    @GetMapping("/back")
    public String back(Model model){
        model.addAttribute("shoopingCart", shoopingCart);
        return "index.html";
    }

    @GetMapping("/addLakier")
    public String addLakier(Model model, ProductDto dto){
        addProductToShoopingCart(dto.getProductId(), dto.getQuantity());
        model.addAttribute("shoopingCart", shoopingCart);
        return "lakiery.html";
    }

    @GetMapping("/addZele")
    public String addZele(Model model, ProductDto dto){
        addProductToShoopingCart(dto.getProductId(), dto.getQuantity());
        model.addAttribute("shoopingCart", shoopingCart);
        return "zele.html";
    }

    @GetMapping("/addAkcesoria")
    public String addAkcesoria(Model model, ProductDto dto){
        addProductToShoopingCart(dto.getProductId(), dto.getQuantity());
        model.addAttribute("shoopingCart", shoopingCart);
        return "akcesoria.html";
    }

    @GetMapping("/summary")
    public String summary(Model model){
        model.addAttribute(new OrderDto());
        model.addAttribute("shoopingCart", shoopingCart);
        return "zamownie.html";
    }

    @PostMapping("/makeOrder")
    public String makeOrder(Model model, OrderDto dto, Client client, Address address) {
        Order order = orderService.saveOrder(orderMapper.mapOrder(dto, shoopingCart));
        model.addAttribute("order", order);
        model.addAttribute("client", client);
        model.addAttribute("address", address);
        changeAmountInDatabase(shoopingCart);
        shoopingCart = new ShoopingCart();
        return "podziekowanie.html";
    }

    @GetMapping("/cancel")
    public String cancel(Model model){
        shoopingCart = new ShoopingCart();
        model.addAttribute("shoopingCart", shoopingCart);
        return "index.html";
    }

    private void addProductToShoopingCart(Long producyId, Integer quantity) {
        Product product = productService.findProductById(producyId)
                .orElseThrow(() -> {throw new NoSuchElementException("Nie znaleziono produktu");});
        ShoopingCartItem item = new ShoopingCartItem(product, quantity);
        shoopingCart.getItems().add(item);
    }

    private void changeAmountInDatabase(ShoopingCart shoopingCart) throws ToMuchException {
        shoopingCart.getItems().forEach(item -> {
            Product product = productService.findProductById(item.getProduct().getId())
                    .orElseThrow(() -> {throw new NoSuchElementException("Nie znaleziono produktu");});
            if (item.getQuantity() > product.getIlosc()) {
                throw new ToMuchException("Zbyt ma??o produktu w mgazynie");
            }
            product.setIlosc(product.getIlosc() - item.getQuantity());
            productService.savePrduct(product);
        });
    }



}
