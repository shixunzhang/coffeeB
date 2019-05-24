package com.entity;

import lombok.Data;

import javax.persistence.Transient;
import java.util.Date;

@Data
public class CoffeeAdminister {

    private int administerId;
    private String administerName;
    private  String administerPassword;
    private  String administerNick;
    private Date createdTime;
    private Date updateTime;
    private int deletedFlag;

    @Transient
    private Integer pageNum;
    @Transient
    private Integer pageSize;
}
