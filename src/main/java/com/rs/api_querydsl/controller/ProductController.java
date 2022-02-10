package com.rs.api_querydsl.controller;

import com.rs.api_querydsl.model.ApiResponse;
import com.rs.api_querydsl.model.dto.ProductRequest;
import com.rs.api_querydsl.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.rs.api_querydsl.service.CategoryService;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/categories")
    public ApiResponse getCategories(){
        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setData(categoryService.getCategories());
        return apiResponse;
    }

    @GetMapping("/products")
    public ApiResponse getProducts(ProductRequest request) {
        ApiResponse apiResponse = new ApiResponse();
        long total = productService.selectCount(request);
        apiResponse.setData("products", productService.selectAll(request));
        apiResponse.setData("total", total);
        apiResponse.setData("pageCount", total % request.getRows() == 0 ? total / request.getRows() : total / request.getRows() + 1);
        return apiResponse;
    }

    @GetMapping("/product/{productId}")
    public ApiResponse getProduct(ProductRequest request) {
        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setData(productService.selectById(request.getProductId()));
        return apiResponse;
    }
}
