package com.test.dao;

import com.test.entity.CourseLibraryAggregate;
import com.test.entity.UserCourse;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserCourseDao {

    void batchInsertUserCourse(@Param("list")List<UserCourse> list);

    List<CourseLibraryAggregate> selectCourseLibrary(@Param("userId") Long userId);

}
