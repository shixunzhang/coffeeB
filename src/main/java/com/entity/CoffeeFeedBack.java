package com.entity;

import lombok.Data;

import java.util.Date;

@Data
public class CoffeeFeedBack {

    private int feedbackId;
    private int userId;
    private String feedbackText;
    private  String contactInformation;
    private Date createdTime;
    private Date updateTime;
    private int deletedFlag;
}
