package com.masteraggregator.controller;

import com.masteraggregator.dto.OrderDTO;
import com.masteraggregator.entity.Category;
import com.masteraggregator.entity.Order;
import com.masteraggregator.entity.User;
import com.masteraggregator.service.CategoryService;
import com.masteraggregator.service.OrderService;
import com.masteraggregator.service.UserService;
import com.masteraggregator.utils.Status_Order;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;
    private final UserService userService;
    private final CategoryService categoryService;

    @PostMapping
    public Order create(@RequestBody OrderDTO dto) {
        User client = userService.getById(dto.getClientId());
        Category category = categoryService.getById(dto.getCategoryId());

        Order order = Order.builder()
                .title(dto.getTitle())
                .description(dto.getDescription())
                .client(client)
                .category(category)
                .address(dto.getAddress())
                .latitude(dto.getLatitude())
                .longitude(dto.getLongitude())
                .status_order(Status_Order.CREATED)
                .build();

        return orderService.createOrder(order);
    }

    @GetMapping("/client/{clientId}")
    public List<Order> getByClient(@PathVariable Long clientId) {
        return orderService.getOrdersByClient(clientId);
    }

    @GetMapping("/{id}")
    public Order getById(@PathVariable Long id) {
        return orderService.getOrderById(id);
    }
}
