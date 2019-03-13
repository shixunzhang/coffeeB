package com.entity;

import lombok.Data;

import java.util.Date;

@Data
public class CoffeeShopping {
    private int shoppingId;
    private int userId;
    private int goodsId;
    private int shoppingNumber;
    private double totalPrice;
    private int goodSize;
    private int goodSugar;
    private Date createdTime;
    private Date updatedTime;
    private int deletedFlag;
    private String goodName;
    private double goodPrice;
}
