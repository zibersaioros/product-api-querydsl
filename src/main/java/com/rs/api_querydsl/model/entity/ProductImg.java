package com.rs.api_querydsl.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.springframework.util.StringUtils;

import javax.persistence.*;

@Getter @Setter
@Entity
public class ProductImg {
    public static final String TYPE_PRODUCT = "PRODUCT";
    public static final String TYPE_MAKER = "MAKER";
    public static final String TYPE_DESCRIPTION = "DESC";

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer imgId;

    @ManyToOne
    @JoinColumn(name="product_id")
    @JsonBackReference
    private ProductList product;

    @Column
    private String imgUrl;
    @Column
    @JsonIgnore
    private String path;
    @Column
    private String imgDisplay;
    @Column
    private String type;

    @JsonIgnore
    public String getFilename(){
        if(path != null){
            return StringUtils.getFilename(StringUtils.cleanPath(path));
        }
        return "";
    }
}
