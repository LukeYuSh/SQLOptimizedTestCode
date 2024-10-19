package com.test;

import com.test.dao.UserCourseDao;
import com.test.entity.CourseLibraryAggregate;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class ExperimentTest {

    @Resource
    private UserCourseDao userCourseDao;

    private static final int QUERY_TIMES = 20;

    @Test
    public void test_selectCourseLibrary(){
        long totalTime = 0;

        // 多次执行查询，记录耗时
        for (int i = 0; i < QUERY_TIMES; i++) {
            long startTime = System.currentTimeMillis(); // 记录开始时间
            userCourseDao.selectCourseLibrary(2L); // 调用 Mapper 方法
            long endTime = System.currentTimeMillis(); // 记录结束时间

            long duration = endTime - startTime; // 计算单次查询耗时
            totalTime += duration; // 累加到总时间
            log.info("第 {} 次查询耗时: {} 秒", i+1, duration/1000.0);
        }

        // 计算平均耗时
        long averageTime = totalTime / QUERY_TIMES;
        log.info("查询 {} 次的平均耗时： {} 秒", QUERY_TIMES, averageTime/1000.0);
    }

}
