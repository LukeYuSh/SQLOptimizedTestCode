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
public class Coach {

    private Long id;
    private String name;
    private String photo;
    private Date createTime;
    private Date updateTime;

}
