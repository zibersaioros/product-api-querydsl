package com.rs.api_querydsl.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter @Setter
@Table(name="product")
public class ProductDetail extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer productId;

    @Column(length = 100, nullable = false)
    private String productName; // 상품명

    @Column
    private String modelName; // 모델명

    @Column(length = 100, nullable = false)
    private String maker; // 제조사

    @Column
    private String requestUrl; // 신청 링크

    @Column
    private String expOwnership; // 만기시 소유권

    @Column
    private String standard; // 상품규격

    @Column
    private String deliveryType; // 납품유형

    @Column
    private Integer price; // 일시불

    @Column
    private String noticeInfo; // 상품 고시 정보

    @Column
    private String deliveryInfoFlag; // 설치/배송 정보 여부

    @Column
    private String deliveryInfo; // 설치/배송 정보

    @Column
    private String refundInfoFlag; // 환불 정보 여부

    @Column
    private String refundInfo; // 환불 정보

    @Column
    private String under19age; // 19세 미만 구매

    @Column
    private String serviceTel; // 소비자상담관련 전화번호

    @Column
    private String descriptionImgInfo; // 상품 설명 이미지



    @OneToMany(mappedBy = "product" )
    @JsonManagedReference
    private List<ProductImg> productImgs;

    @OneToMany(mappedBy = "product")
    @JsonManagedReference
    @OrderBy("periodPrice")
    private List<ProductPrice> productPrices;

    @OneToMany(mappedBy="product")
    @JsonManagedReference
    @OrderBy("sort")
    private List<ProductCardDiscount> cardDiscounts;

    @ManyToOne
    @JoinColumn(name = "seller_code", referencedColumnName = "sellerCode")
    private Seller seller;







    @Column
    @JsonIgnore
    private String displayStatus; // 판매상태

    @Column
    @JsonIgnore
    private String approvalCondition; // 승인상태

    @Column
    @JsonIgnore
    private String disapprovalReason; // 거절사유

    @Column
    @JsonIgnore
    private String isTrash; // 삭제여부

    @Column
    @JsonIgnore
    private String tcProductCode; // 티캐 상품코드

    @Column
    @JsonIgnore
    private Float commission; // 수수료

    @Column
    @JsonIgnore
    private String category; // 대분류, 중분루, 소분류

    @Column
    @JsonIgnore
    private String productCode; // 판매자 상품코드

    @Column
    @JsonIgnore
    private LocalDateTime salePeriodStart; // 판매기간_start

    @Column
    @JsonIgnore
    private LocalDateTime salePeriodEnd; // 판매기간_end















}
