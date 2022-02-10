package com.rs.api_querydsl.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter @Setter
public class Seller implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Integer sellerId;

    @Column
    @JsonIgnore
    private String sellerCode;

    @Column
    private String companyName;

    @Column
    private String representative;

    @Column
    private String location;

    @Column
    private String tel;

    @Column
    private String registrationNum;


}
