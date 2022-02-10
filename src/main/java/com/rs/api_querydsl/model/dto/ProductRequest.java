package com.rs.api_querydsl.model.dto;

import lombok.Data;

@Data
public class ProductRequest {
    private Integer productId;
    private String category;
    private Integer sort = 1;
    private String keyword;
    private Integer page = 1;
    private Integer rows = 20;
}
