package com.rs.api_querydsl.service;

import com.google.common.collect.Maps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import com.rs.api_querydsl.model.entity.ProductCategory;
import com.rs.api_querydsl.repository.CategoryRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    @Value("${img.server.url}")
    private String imgServerUrl;


    @Override
    public Map<String, List<ProductCategory>> getCategories() {
        Map<String, List<ProductCategory>> tree = Maps.newHashMap();
        List<ProductCategory> categories = categoryRepository.findAllByUseYnAndDisplayYn("Y", "Y");
        for (ProductCategory category : categories) {
            if(StringUtils.hasText(category.getImgUrl()))
                category.setImgUrl(imgServerUrl + category.getImgUrl());
            String parent = category.getParentCode();
            if(!StringUtils.hasText(parent)){
                parent = "root";
            }
            if(!tree.containsKey(parent)){
                tree.put(parent, new ArrayList<>());
            }
            tree.get(parent).add(category);
        }
        return tree;
    }
}
