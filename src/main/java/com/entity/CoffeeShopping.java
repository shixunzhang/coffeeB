package com.entity;

import lombok.Data;

import javax.persistence.Transient;
import java.util.Date;

@Data
public class CoffeeShopping {
    private int shoppingId;
    private int userId;
    private int goodId;
    private int shoppingNumber;
    private double totalPrice;
    private  int goodCategory;
    private int goodSize;
    private int goodSugar;
    private Date createdTime;
    private Date updatedTime;
    private int deletedFlag;
    private String goodName;
    private double goodPrice;

    @Transient
    private Integer pageNum;
    @Transient
    private Integer pageSize;
}
