package com.rs.api_querydsl.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import com.rs.api_querydsl.model.entity.ProductDetail;

public interface ProductDetailRepository extends JpaRepository<ProductDetail, Integer> {
}
