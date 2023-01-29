package com.example.drogeria.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class ShoopingCartItem {
    @SequenceGenerator(
            name = "sequenceCart",
            sequenceName = "sequenceCart",
            allocationSize = 1
    )
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "sequenceCart"
    )
    private Long id;
    private Integer quantity;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PRODUCT_ID")
    private Product product;

    public ShoopingCartItem(Product product, Integer quantity) {
        this.product = product;
        this.quantity = quantity;
    }
}
