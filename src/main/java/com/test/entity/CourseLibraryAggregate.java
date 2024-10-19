package com.test.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CourseLibraryAggregate{

    private Long id;
    private String name;
    private String coachName;
    private String image;
    private String kind;
    private Integer hotIndex;
    private Boolean complete;
    private Long gId;
    private Boolean locking;

}
