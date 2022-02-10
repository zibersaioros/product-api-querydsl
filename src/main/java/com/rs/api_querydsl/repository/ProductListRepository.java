package com.rs.api_querydsl.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import com.rs.api_querydsl.model.entity.ProductList;

public interface ProductListRepository extends JpaRepository<ProductList, Integer>, ProductListRepositoryCustom {
}
