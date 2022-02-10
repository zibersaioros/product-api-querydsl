package com.rs.api_querydsl.service;

import com.querydsl.core.QueryResults;
import com.rs.api_querydsl.model.dto.ProductRequest;
import com.rs.api_querydsl.model.entity.ProductCardDiscount;
import com.rs.api_querydsl.repository.ProductDetailRepository;
import com.rs.api_querydsl.repository.ProductListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.rs.api_querydsl.model.entity.ProductDetail;
import com.rs.api_querydsl.model.entity.ProductList;
import com.rs.api_querydsl.model.entity.ProductImg;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class ProductServiceImpl implements ProductService {

    @Value("${img.server.url}")
    private String imgServerUrl;

    @Autowired
    ProductListRepository productListRepository;

    @Autowired
    ProductDetailRepository productDetailRepository;

    @Override
    public List<ProductList> selectAll(ProductRequest request) {
        QueryResults<ProductList> productQueryResults = productListRepository.selectList(request);
        Stream<ProductList> stream = productQueryResults.getResults().stream();
        Comparator<ProductList> productComparator;
        if(request.getSort() == 2){
            productComparator = Comparator.comparing(this::getDiscountedPrice);
        } else if(request.getSort() == 3){
            productComparator = (o1, o2) -> getDiscountedPrice(o2).compareTo(getDiscountedPrice(o1));
        } else {
            productComparator = Comparator.comparing(ProductList::getCreateDate);
        }
        return stream
            .sorted(productComparator)
            .skip((request.getPage() - 1) * request.getRows())
            .limit(request.getRows())
            .map(product -> modifyImageServerUrl(product))
            .collect(Collectors.toList());
    }

    @Override
    public Long selectCount(ProductRequest request) {
        QueryResults<ProductList> productQueryResults = productListRepository.selectList(request);
        return productQueryResults.getTotal();
    }

    @Override
    public ProductDetail selectById(Integer productId) {
        return productDetailRepository.findById(productId).orElse(null);
    }

    public Integer getDiscountedPrice(ProductList product){
        Integer price = null;
        if(product.getProductPrices() != null && product.getProductPrices().size() > 0){
            price = product.getProductPrices().get(0).getPeriodPrice();
        } else {
            price = product.getPrice();
        }
        int maxDiscount = 0;
        for (ProductCardDiscount cardDiscount : product.getCardDiscounts()) {
            maxDiscount = Math.max(maxDiscount, Optional.ofNullable(cardDiscount.getDiscount1()).orElse(0));
            maxDiscount = Math.max(maxDiscount, Optional.ofNullable(cardDiscount.getDiscount2()).orElse(0));
            maxDiscount = Math.max(maxDiscount, Optional.ofNullable(cardDiscount.getDiscount3()).orElse(0));
            maxDiscount = Math.max(maxDiscount, Optional.ofNullable(cardDiscount.getDiscount4()).orElse(0));
            maxDiscount = Math.max(maxDiscount, Optional.ofNullable(cardDiscount.getDiscount5()).orElse(0));
        }
        return Optional.ofNullable(price).orElse(0) - maxDiscount;
    }

    private ProductList modifyImageServerUrl(ProductList product){
        for (ProductImg productImg : product.getProductImgs()) {
            productImg.setImgUrl(imgServerUrl + productImg.getImgUrl());
        }
        return product;
    }
}
