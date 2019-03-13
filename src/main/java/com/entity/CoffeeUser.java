package com.entity;

import lombok.Data;

import java.util.Date;

@Data
public class CoffeeUser {
    private int userId;
    private String userName;
    private int userSex;
    private String userPhone;
    private String userAddress;
    private String userPortrait;
    private Date createdTime;
    private Date updatedTime;
    private int deletedFlag;
    private String userNick;
    private String userPassword;

}
