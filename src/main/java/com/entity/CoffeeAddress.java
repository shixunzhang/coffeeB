package com.entity;

import lombok.Data;

import javax.persistence.Transient;
import java.util.Date;

@Data
public class CoffeeAddress {

    private int addressId;
    private int userId;
    private String address;
    private String contacts;
    private String phone;
    private Date createdTime;
    private Date updateTime;
    private int deletedFlag;


    @Transient
    private int major;
}
