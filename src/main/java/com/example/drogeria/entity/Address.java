package com.example.drogeria.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor

public class Address {

    @SequenceGenerator(
            name = "sequenceAddress",
            sequenceName = "sequenceAddress",
            allocationSize = 1
    )
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "sequenceAddress"
    )

    private Long id;
    private String city;
    private String street;
    private String number;
    private String postcode;
    @OneToOne(mappedBy = "address")
    private Order order;
}
