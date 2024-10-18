package com.test.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Course {

    private Long id;
    private String name;
    private Long coachId;
    private String kind;
    private Integer duration;
    private String image;
    private Date createTime;
    private Date updateTime;
    private Boolean deleted;

}
