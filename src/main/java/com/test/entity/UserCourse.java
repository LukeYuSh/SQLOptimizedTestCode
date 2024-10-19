package com.test.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserCourse {

    private Long id;
    private Long userId;
    private Long courseId;
    private Long coachId;
    private String coachName;


}
