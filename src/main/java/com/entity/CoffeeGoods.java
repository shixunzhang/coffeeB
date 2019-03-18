package com.entity;

import lombok.Data;

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


}
