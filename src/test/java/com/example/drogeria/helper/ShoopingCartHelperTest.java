package com.example.drogeria.helper;

import com.example.drogeria.entity.Product;
import com.example.drogeria.entity.ShoopingCartItem;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class ShoopingCartHelperTest {

    private static List<ShoopingCartItem> items;
    private static ShoopingCartHelper helper;

    @BeforeAll
    public static void setUp() {
        items = prepareShoopingCartItems();
        helper = new ShoopingCartHelper();
    }

    @Test
    void cost_all_products_shuld_be_calculate_correct() {
        Double allCost = helper.getCostAllProducts(items);
        assertEquals(58.5, allCost);
    }

    @Test
    void cost_all_products_shuld_be_calculate_wrong() {
        Double allCost = helper.getCostAllProducts(items);
        assertNotEquals(60.5, allCost);
    }

    @Test
    void amount_of_products_shuld_be_calculate_correct() {
        Integer amount = helper.getAmountOfProdts(items);
        assertEquals(7, amount);
    }

    @Test
    void amount_go_products_shuld_be_calculate_wrong() {
        Integer amount = helper.getAmountOfProdts(items);
        assertNotEquals(17, amount);
    }

    static List<ShoopingCartItem> prepareShoopingCartItems() {
        List<ShoopingCartItem> items = new ArrayList<>();

        ShoopingCartItem item1 = new ShoopingCartItem(new Product(1L, "lakier", 5.50, 5), 5);
        ShoopingCartItem item2 = new ShoopingCartItem(new Product(2L, "żel", 15.50, 2), 2);
        items.add(item1);
        items.add(item2);

        return items;
    }
}