package com.masteraggregator.exception;

public class OrderResponseNotFoundException extends RuntimeException {
    public OrderResponseNotFoundException(Long id) {
        super("OrderResponse not found with id=" + id);
    }
}