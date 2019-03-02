package com.entity;

import lombok.Data;

import java.security.PrivateKey;
import java.util.Date;

@Data
public class CoffeeGoods {
    private int goodsId;
    private String goodsName;
    private String goodsNameEn;
    private  int goodsCategory;
    private String goodsImg;
    private int goodsPriceSmall;
    private int goodsPriceBetween;
    private int goodsPriceBig;
    private Date createdTime;
    private Date updateTime;
    private int deletedFlag;


}
