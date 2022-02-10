package com.rs.api_querydsl.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
public class ProductPrice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // AUTO_INCREMENT
    @JsonIgnore
    private Integer priceId;

    @ManyToOne
    @JoinColumn(name="product_id")
    @JsonBackReference
    private ProductList product;

    @Column
    private Integer period;

    @Column
    private Integer periodPrice;
}
