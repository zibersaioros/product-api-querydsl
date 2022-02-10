package com.rs.api_querydsl.repository;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.QueryResults;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.rs.api_querydsl.model.dto.ProductRequest;
import com.rs.api_querydsl.model.entity.QProductList;
import lombok.RequiredArgsConstructor;
import org.springframework.util.StringUtils;
import com.rs.api_querydsl.model.entity.ProductList;

@RequiredArgsConstructor
public class ProductListRepositoryCustomImpl implements ProductListRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    @Override
    public QueryResults<ProductList> selectList(ProductRequest request) {
        QProductList productList = QProductList.productList;

        JPAQuery<ProductList> query = queryFactory.selectFrom(productList)
            .where(productList.isTrash.eq("N"))
            .where(productList.displayStatus.eq("Y"));
//            .limit(request.getRows())
//            .offset((request.getPage() - 1) * request.getRows());


        if(StringUtils.hasText(request.getKeyword())){
            BooleanBuilder booleanBuilder = new BooleanBuilder();
            booleanBuilder.or(productList.productName.contains(request.getKeyword()))
                .or(productList.modelName.contains(request.getKeyword()));
            query.where(booleanBuilder);
        }
        if(StringUtils.hasText(request.getCategory())){
            query.where(productList.category.contains(request.getCategory()));
        }

        return query.fetchResults();
    }
}
