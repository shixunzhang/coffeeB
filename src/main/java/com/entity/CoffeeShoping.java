package com.entity;

import lombok.Data;

import java.util.Date;

@Data
public class CoffeeShoping {
    private int shopingId;
    private int userId;
    private int goodsId;
    private int shopingNumber;
    private int totalPrice;
    private int goodSize;
    private int goodSugar;
    private Date createdTime;
    private Date updatedTime;
    private int deletedFlag;
}
