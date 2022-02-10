package com.rs.api_querydsl.repository;

import com.querydsl.core.QueryResults;
import com.rs.api_querydsl.model.dto.ProductRequest;
import com.rs.api_querydsl.model.entity.ProductList;

public interface ProductListRepositoryCustom {
    QueryResults<ProductList> selectList(ProductRequest request);
}
