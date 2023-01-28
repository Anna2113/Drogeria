package com.example.drogeria.helper;

import com.example.drogeria.entity.ShoopingCartItem;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
public class ShoopingCartHelper {

    public Double getCostAllProducts(List<ShoopingCartItem> items) {
        Double sum = 0.0;
        for (ShoopingCartItem item : items) {
            sum += item.getQuantity() * item.getProduct().getPrice();
        }
        return sum;
    }

    public Integer getAmountOfProdts(List<ShoopingCartItem> items) {
        Integer sum = 0;
        for (ShoopingCartItem item : items) {
            sum += item.getQuantity();
        }
        return sum;
    }
}
