package com.masteraggregator.repository;


import com.masteraggregator.entity.OrderResponse;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderResponseRepository extends JpaRepository<OrderResponse, Long> {
    List<OrderResponse> findByOrder_Id(Long orderId);
    List<OrderResponse> findByMaster_Id(Long masterId);
}