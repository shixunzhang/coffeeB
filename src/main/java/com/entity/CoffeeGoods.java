package com.entity;

import lombok.Data;

import javax.persistence.Transient;
import java.util.Date;

@Data
public class CoffeeGoods {
    private int goodsId;
    private String goodsName;
    private String goodsNameEn;
    private  int goodsCategory;
    private String goodsImg;
    private double goodsPriceSmall;
    private double goodsPriceBetween;
    private double goodsPriceBig;
    private Date createdTime;
    private Date updateTime;
    private int deletedFlag;

    @Transient
    private Integer pageNum;
    @Transient
    private Integer pageSize;


}
