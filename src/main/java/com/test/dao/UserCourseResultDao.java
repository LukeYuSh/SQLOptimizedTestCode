package com.test.dao;

import com.test.entity.UserCourseResult;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserCourseResultDao {

    void batchInsertUserCourseResult(@Param("list")List<UserCourseResult> list);

}
