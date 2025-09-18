package com.masteraggregator.service;


import com.masteraggregator.entity.Order;
import com.masteraggregator.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    private final OrderRepository repo;

    public OrderService(OrderRepository repo) {
        this.repo = repo;
    }

    public Order createOrder(Order order) {
        return repo.save(order);
    }

    public List<Order> getOrdersByClient(Long clientId) {
        return repo.findByClientId(clientId);
    }

    public Order getOrderById(Long id) {
        return repo.findById(id).orElseThrow(() -> new RuntimeException("Order not found"));
    }
}
