package com.rs.api_querydsl.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.rs.api_querydsl.model.entity.ProductCategory;

import java.util.List;

public interface CategoryRepository extends JpaRepository<ProductCategory, String> {

    List<ProductCategory> findAllByUseYnAndDisplayYn(String useYn, String displayYn);
}
