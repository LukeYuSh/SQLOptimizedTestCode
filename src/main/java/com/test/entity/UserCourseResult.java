package com.test.entity;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class UserCourseResult {

    private Long id;
    private Long userCourseId;
    private BigDecimal score;
    private Integer duration;
    private String extras;

}
