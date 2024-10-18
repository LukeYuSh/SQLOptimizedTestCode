package com.test.entity;

import lombok.Data;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Data
public class GitTake {

    private Long id;
    private Long userId;
    public Map<String, Object> gift = new HashMap<>();
    private Date expireTime;

}
