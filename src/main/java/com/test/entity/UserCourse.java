package com.test.entity;

import lombok.Data;

@Data
public class UserCourse {

    private Long id;
    private Long userId;
    private Long courseId;
    private Long coachId;
    private String coachName;


}
