package com.test.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Builder
@AllArgsConstructor
@NoArgsConstructor
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
