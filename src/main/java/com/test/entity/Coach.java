package com.test.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Coach {

    private Long id;
    private String name;
    private String photo;
    private Date createTime;
    private Date updateTime;

}
