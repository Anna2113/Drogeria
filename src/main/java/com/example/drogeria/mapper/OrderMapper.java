package com.example.drogeria.mapper;

import com.example.drogeria.dto.OrderDto;
import com.example.drogeria.entity.*;
import com.example.drogeria.helper.ShoopingCartHelper;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
public class OrderMapper {

    private ShoopingCartHelper shoopingCartHelper = new ShoopingCartHelper();

    public Order mapOrder(OrderDto dto, ShoopingCart shoopingCart) {
        Order order = new Order();
        order.setClient(mapClient(dto));
        order.setAddress(mapAddres(dto));
        order.setShoopingCart(shoopingCart);
        order.setCostAllProduct(getCostAllProducts(shoopingCart.getItems()));
        order.setAmount(getAmountOfProduts(shoopingCart.getItems()));
        return order;
    }

    private Client mapClient(OrderDto dto) {
        Client client = new Client();
        client.setFirstName(dto.getFirstName());
        client.setLastName(dto.getLastName());
        client.setEmail(dto.getEmail());
        client.setNumberOfPhone(dto.getNumberOfPhone());
        return client;
    }

    private Address mapAddres(OrderDto dto) {
        Address address = new Address();
        address.setCity(dto.getCity());
        address.setStreet(dto.getStreet());
        address.setNumber(dto.getNumber());
        address.setPostcode(dto.getPostcode());
        address.setPostcodeOfCity(dto.getPostcodeOfCity());
        return address;
    }

    private Double getCostAllProducts(List<ShoopingCartItem> items) {
        return shoopingCartHelper.getCostAllProducts(items);
    }

    private Integer getAmountOfProduts(List<ShoopingCartItem> items) {
        return shoopingCartHelper.getAmountOfProdts(items);
    }
}
