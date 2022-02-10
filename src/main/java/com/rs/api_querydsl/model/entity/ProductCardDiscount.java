package com.rs.api_querydsl.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
public class ProductCardDiscount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // AUTO_INCREMENT
    @JsonIgnore
    private Integer cardId;

    @ManyToOne
    @JoinColumn(name="product_id")
    @JsonBackReference
    private ProductList product;

    @Column
    private String cardCompany;

    @Column
    private String cardName;

    @Column
    private Integer usePerformance1;

    @Column
    private Integer discount1;

    @Column
    private Integer	usePerformance2;

    @Column
    private Integer discount2;

    @Column
    private Integer usePerformance3;

    @Column
    private Integer discount3;

    @Column
    private Integer usePerformance4;

    @Column
    private Integer discount4;

    @Column
    private Integer usePerformance5;

    @Column
    private Integer discount5;

    @Column
    private Integer annualFeeInternal;

    @Column
    private Integer annualFeeOverseas;

    @Column
    private String duplicateDiscount;

    @Column
    private String issueCardWayArs;

    @Column
    private String issueCardWayOnline;

    @Column
    private String issueCardWayEtc;

    @Column
    private Integer sort;

    @Column
    @JsonIgnore
    private String sellerCode;
}
