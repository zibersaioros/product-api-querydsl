package com.rs.api_querydsl.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Getter @Setter
@Entity
public class ProductCategory {
    @Id
    private String code;
    @Column
    private String name;
    @Column
    private String nameEng;
    @Column
    private Integer depth;
    @Column
    private String parentCode;
    @Column
    private Integer sort;
    @Column
    private String imgUrl;
    @Column
    @JsonIgnore
    private String imgPath;
    @Column
    @JsonIgnore
    private String useYn;
    @Column
    @JsonIgnore
    private String displayYn;
}
