package com.test.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserCourseResult {

    private Long id;
    private Long userCourseId;
    private BigDecimal score;
    private Integer duration;
    private String extras;

}
