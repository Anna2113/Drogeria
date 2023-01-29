package com.example.drogeria.mapper;

import com.example.drogeria.dto.OrderDto;
import com.example.drogeria.entity.Order;
import com.example.drogeria.entity.Product;
import com.example.drogeria.entity.ShoopingCart;
import com.example.drogeria.entity.ShoopingCartItem;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class OrderMapperTest {

    private static OrderMapper orderMapper;
    private static OrderDto dto;
    private static ShoopingCart shoopingCart;

    @BeforeAll
    public static void setUp() {
        orderMapper = new OrderMapper();
        dto = prepareOrderDto();
        shoopingCart = prepareShoopingCart();
    }

    @Test
    void data_shold_be_mapped_correctly() {
        Order order = orderMapper.mapOrder(dto, shoopingCart);

        assertEquals(dto.getFirstName(), order.getClient().getFirstName());
        assertEquals(dto.getLastName(), order.getClient().getLastName());
        assertEquals(dto.getEmail(), order.getClient().getEmail());
        assertEquals(dto.getNumberOfPhone(), order.getClient().getNumberOfPhone());
        assertEquals(dto.getCity(), order.getAddress().getCity());
        assertEquals(dto.getStreet(), order.getAddress().getStreet());
        assertEquals(dto.getNumber(), order.getAddress().getNumber());
        assertEquals(dto.getPostcode(), order.getAddress().getPostcode());
    }

    static OrderDto prepareOrderDto() {
        OrderDto dto = new OrderDto();

        dto.setFirstName("Jan");
        dto.setLastName("Kowalski");
        dto.setEmail("jkowalski@gmail.com");
        dto.setNumberOfPhone("13456789");
        dto.setCity("Lublin");
        dto.setStreet("Konstantynów");
        dto.setNumber("1H");
        dto.setPostcode("20-708");

        return dto;
    }

    static ShoopingCart prepareShoopingCart() {
        ShoopingCart shoopingCart = new ShoopingCart();

        ShoopingCartItem item1 = new ShoopingCartItem(new Product(1L, "lakier", 5.50, 5), 5);
        ShoopingCartItem item2 = new ShoopingCartItem(new Product(2L, "żel", 15.50, 2), 2);
        shoopingCart.getItems().add(item1);
        shoopingCart.getItems().add(item2);

        return shoopingCart;
    }

}