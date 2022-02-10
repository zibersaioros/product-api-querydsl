package com.rs.api_querydsl.service;

import com.rs.api_querydsl.model.entity.ProductCategory;

import java.util.List;
import java.util.Map;

public interface CategoryService {
    Map<String, List<ProductCategory>> getCategories();
}
