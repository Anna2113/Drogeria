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

public class Product {

    @SequenceGenerator(
            name = "sequenceProduct",
            sequenceName = "sequenceProduct",
            allocationSize = 1
    )
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "sequenceProduct"
    )

    private Long id;
    private String name;
    private Double price;
    private Integer amount;
    private String label;

}
