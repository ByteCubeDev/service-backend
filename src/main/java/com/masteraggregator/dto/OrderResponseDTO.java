package com.masteraggregator.dto;
import lombok.Data;

import java.time.Instant;

@Data
public class OrderResponseDTO {
    private Long orderId;
    private Long masterId;
    private Double proposedPrice;
    private Instant proposedDate;
    private String comment;
}
