package com.example.drogeria.exeption;

public class ToMuchException extends RuntimeException {
    public ToMuchException(String message) {
        super(message);
    }
}
