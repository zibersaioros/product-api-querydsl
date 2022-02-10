package com.rs.api_querydsl.model.entity;

import lombok.*;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;


@Getter @Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductCategoryMap {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long no;

    @ManyToOne
    @JoinColumn(name="product_id")
    private ProductList product;

    @NotFound(action= NotFoundAction.IGNORE)
    @ManyToOne
    @JoinColumn(name="category_code")
    private ProductCategory category;
}
