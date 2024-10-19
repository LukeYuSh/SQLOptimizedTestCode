package com.test.entity;

import com.alibaba.fastjson2.JSON;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class GiftTake {

    private Long id;
    private Long userId;
    private String gift;
//    public Map<String, Object> gift = new HashMap<>();
    private Date expireTime;

}
