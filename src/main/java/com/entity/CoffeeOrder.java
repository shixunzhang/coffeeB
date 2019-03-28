package com.entity;

import lombok.Data;

import java.util.Date;

@Data
public class CoffeeOrder {

    private int orderId;
    private int userId;
    private Date createdTime;
    private Date updatedTime;
    private int deletedFlag;
    private int finishFlag;
    private int orderNumber;
    private double totalPrice;
    private String orderAddress;
    private int goodsId;
    private int goodsSize;
    private int goodsSugar;
    private String orderNo;
    private String goodName;
    private int takeOut;

}
