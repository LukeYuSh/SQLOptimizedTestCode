package com.test.dao;

import com.test.entity.Coach;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CoachDao {


    void batchInsert(@Param("list") List<Coach> list);


}
