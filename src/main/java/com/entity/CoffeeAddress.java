package com.entity;

import lombok.Data;
import java.util.Date;

@Data
public class CoffeeAddress {

    private int addressId;
    private int userId;
    private String address;
    private Date createdTime;
    private Date updateTime;
    private int deletedFlag;
}
