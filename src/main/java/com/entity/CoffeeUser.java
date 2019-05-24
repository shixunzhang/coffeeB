package com.entity;

import lombok.Data;

import javax.persistence.Transient;
import java.util.Date;

@Data
public class CoffeeUser {
    private int userId;
    private String userName;
    private int userSex;
    private String userPhone;
    private int userAddress;
    private String userPortrait;
    private Date createdTime;
    private Date updatedTime;
    private int deletedFlag;
    private String userNick;
    private String userPassword;
    private int takeOut;

    @Transient
    private Integer pageNum;
    @Transient
    private Integer pageSize;
    @Transient
    private String addressString;

}
