package com.masteraggregator.dto;
import lombok.Data;

@Data
public class OrderDTO {
    private String title;
    private String description;
    private Long clientId;
    private Long categoryId;
    private String address;
    private Double latitude;
    private Double longitude;
}

