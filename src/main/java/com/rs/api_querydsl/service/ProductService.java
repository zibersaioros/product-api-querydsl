package com.rs.api_querydsl.service;

import com.rs.api_querydsl.model.dto.ProductRequest;
import com.rs.api_querydsl.model.entity.ProductDetail;
import com.rs.api_querydsl.model.entity.ProductList;

import java.util.List;

public interface ProductService {

    List<ProductList> selectAll(ProductRequest request);

    Long selectCount(ProductRequest request);

    ProductDetail selectById(Integer productId);
}
