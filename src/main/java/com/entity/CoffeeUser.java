package com.entity;

import java.util.Date;

public class CoffeeUser {
    private int userId;
    private String userName;
    private int userSex;
    private String userPhone;
    private String userAddress;
    private String userPortrait;
    private Date createdTime;
    private Date updateTime;
    private int deletedFlag;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getUserSex() {
        return userSex;
    }

    public void setUserSex(int userSex) {
        this.userSex = userSex;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public String getUserPortrait() {
        return userPortrait;
    }

    public void setUserPortrait(String userPortrait) {
        this.userPortrait = userPortrait;
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

    public CoffeeUser(int userId, String userName, int userSex, String userPhone, String userAddress, String userPortrait, Date createdTime, Date updateTime, int deleatFlag) {
        this.userId = userId;
        this.userName = userName;
        this.userSex = userSex;
        this.userPhone = userPhone;
        this.userAddress = userAddress;
        this.userPortrait = userPortrait;
        this.createdTime = createdTime;
        this.updateTime = updateTime;
        this.deletedFlag = deleatFlag;
    }

    public CoffeeUser() {
        super();
    }

    @Override
    public String toString() {
        return "CoffeeUser{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userSex=" + userSex +
                ", userPhone='" + userPhone + '\'' +
                ", userAddress='" + userAddress + '\'' +
                ", userPortrait='" + userPortrait + '\'' +
                ", createdTime=" + createdTime +
                ", updateTime=" + updateTime +
                ", deleatFlag=" + deletedFlag +
                '}';
    }
}
