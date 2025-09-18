package com.masteraggregator.controller;

import com.masteraggregator.entity.OrderResponse;
import com.masteraggregator.service.OrderResponseService;
import com.masteraggregator.utils.Status_Response;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/order-responses")
public class OrderResponseController {

    private final OrderResponseService service;

    public OrderResponseController(OrderResponseService service) {
        this.service = service;
    }

    @PostMapping
    public OrderResponse create(@RequestBody OrderResponse orderResponse) {
        return service.createResponse(orderResponse);
    }

    @GetMapping("/order/{orderId}")
    public List<OrderResponse> getByOrder(@PathVariable Long orderId) {
        return service.getResponsesByOrder(orderId);
    }

    @GetMapping("/master/{masterId}")
    public List<OrderResponse> getByMaster(@PathVariable Long masterId) {
        return service.getResponsesByMaster(masterId);
    }
}

