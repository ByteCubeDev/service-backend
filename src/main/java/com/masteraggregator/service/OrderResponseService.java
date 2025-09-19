package com.masteraggregator.service;

import com.masteraggregator.entity.OrderResponse;
import com.masteraggregator.exception.OrderResponseNotFoundException;
import com.masteraggregator.repository.OrderResponseRepository;
import com.masteraggregator.utils.Status_Response;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderResponseService {
    private final OrderResponseRepository repository;

    @Transactional
    public OrderResponse createResponse(OrderResponse response) {
        // TODO: добавить проверку, что мастер может откликнуться только один раз
        return repository.save(response);
    }

    public List<OrderResponse> getResponsesByOrder(Long orderId) {
        return repository.findByOrder_Id(orderId);
    }

    public List<OrderResponse> getResponsesByMaster(Long masterId) {
        return repository.findByMaster_Id(masterId);
    }

    @Transactional
    public OrderResponse updateStatus(Long responseId, Status_Response newStatus) {
        OrderResponse response = repository.findById(responseId)
                .orElseThrow(() -> new OrderResponseNotFoundException(responseId));

        response.setStatus(newStatus);
        return repository.save(response);
    }

}
