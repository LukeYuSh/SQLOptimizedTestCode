package com.test.dao;

import com.test.entity.Course;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CourseDao {

    void batchInsertCourse(@Param("list")List<Course> list);

}
