package com.entity;

import java.security.PrivateKey;
import java.util.Date;

public class CoffeeGoods {
    private int goodsId;
    private String goodsName;
    private String goodsNameEn;
    private  int goodsCategory;
    private String goodsImg;
    private int goodsPrice;
    private Date createdTime;
    private Date updateTime;
    private int deletedFlag;


    public int getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(int goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getGoodsNameEn() {
        return goodsNameEn;
    }

    public void setGoodsNameEn(String goodsNameEn) {
        this.goodsNameEn = goodsNameEn;
    }

    public int getGoodsCategory() {
        return goodsCategory;
    }

    public void setGoodsCategory(int goodsCategory) {
        this.goodsCategory = goodsCategory;
    }

    public String getGoodsImg() {
        return goodsImg;
    }

    public void setGoodsImg(String goodsImg) {
        this.goodsImg = goodsImg;
    }

    public int getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(int goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public int getDeleatFlag() {
        return deletedFlag;
    }

    public void setDeleatFlag(int deleatFlag) {
        this.deletedFlag = deleatFlag;
    }

    public CoffeeGoods(int goodsId, String goodsName, String goodsNameEn, int goodsCategory, String goodsImg, int goodsPrice, Date createdTime, Date updateTime, int deletedFlag) {
        this.goodsId = goodsId;
        this.goodsName = goodsName;
        this.goodsNameEn = goodsNameEn;
        this.goodsCategory = goodsCategory;
        this.goodsImg = goodsImg;
        this.goodsPrice = goodsPrice;
        this.createdTime = createdTime;
        this.updateTime = updateTime;
        this.deletedFlag = deletedFlag;
    }

    public CoffeeGoods() {
        super();
        // TODO Auto-generated constructor stub
    }

    @Override
    public String toString() {
        return "CoffeeGoods{" +
                "goodsId=" + goodsId +
                ", goodsName='" + goodsName + '\'' +
                ", goodsNameEn='" + goodsNameEn + '\'' +
                ", goodsCategory=" + goodsCategory +
                ", goodsImg='" + goodsImg + '\'' +
                ", goodsPrice=" + goodsPrice +
                ", createdTime=" + createdTime +
                ", updateTime=" + updateTime +
                ", deleatFlag=" + deletedFlag +
                '}';
    }
}
