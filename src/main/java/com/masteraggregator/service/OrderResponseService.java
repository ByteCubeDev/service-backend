package com.masteraggregator.service;

import com.masteraggregator.entity.OrderResponse;
import com.masteraggregator.repository.OrderResponseRepository;
import com.masteraggregator.utils.Status_Response;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderResponseService {

    private final OrderResponseRepository repository;

    public OrderResponseService(OrderResponseRepository repository) {
        this.repository = repository;
    }

    /**
     * Создать новый отклик мастера на заявку
     */
    public OrderResponse createResponse(OrderResponse response) {
        // Тут можно добавить валидацию, например, что мастер может откликнуться только один раз
        return repository.save(response);
    }

    /**
     * Получить все отклики для конкретной заявки
     */
    public List<OrderResponse> getResponsesByOrder(Long orderId) {
        return repository.findByOrder_Id(orderId);
    }

    /**
     * Получить все отклики конкретного мастера
     */
    public List<OrderResponse> getResponsesByMaster(Long masterId) {
        return repository.findByMaster_Id(masterId);
    }

    /**
     * Обновить статус отклика (PENDING -> ACCEPTED / REJECTED)
     */
    public OrderResponse updateStatus(Long responseId, Status_Response newStatus) {
        OrderResponse response = repository.findById(responseId)
                .orElseThrow(() -> new RuntimeException("OrderResponse not found"));
        response.setStatus(newStatus);
        return repository.save(response);
    }
}
