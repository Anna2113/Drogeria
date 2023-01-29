package com.example.drogeria.dto;

import lombok.Data;

@Data
public class OrderDto {
    //    Klient
    private String firstName;
    private String lastName;
    private String email;
    private String numberOfPhone;
    //    Adres
    private String city;
    private String street;
    private String number;
    private String postcode;
}
