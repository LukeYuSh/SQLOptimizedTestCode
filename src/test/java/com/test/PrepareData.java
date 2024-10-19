package com.test;

import com.alibaba.fastjson2.JSON;
import com.test.dao.*;
import com.test.entity.*;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.*;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class PrepareData {

    @Resource
    private CoachDao coachDao;

    @Resource
    private CourseDao courseDao;

    @Resource
    private UserCourseDao userCourseDao;

    @Resource
    private UserCourseResultDao userCourseResultDao;

    @Resource
    private GiftTakeDao giftTakeDao;


    @Test
    public void test_batchInsertCoach(){
        List<Coach> list = new ArrayList<>();
        list.add(Coach.builder()
                .name("A")
                .photo("www.avatar.com")
                .build());
        list.add(Coach.builder()
                .name("B")
                .photo("www.avatar.com")
                .build());
        list.add(Coach.builder()
                .name("C")
                .photo("www.avatar.com")
                .build());
        list.add(Coach.builder()
                .name("D")
                .photo("www.avatar.com")
                .build());
        list.add(Coach.builder()
                .name("E")
                .photo("www.avatar.com")
                .build());
        list.add(Coach.builder()
                .name("F")
                .photo("www.avatar.com")
                .build());
        coachDao.batchInsert(list);
    }


    @Test
    public void test_batchInsertCourse(){
        List<String> nameDic = Arrays.asList("FOOTBALL", "BADMINTON", "BICYCLE", "RUN", "DANCE", "TENNIS");
        List<Long> coachDic = Arrays.asList(1L, 2L, 3L, 4L, 5L, 6L);
        List<String> kindDic = Arrays.asList("INDOOR", "OUTDOOR");
        List<Integer> durationDic = Arrays.asList(2000,6000,8000,6200,1600);
        String image = "www.cover.com";
        Random random = new Random();

        for(int i=0;i<5;i++){
            List<Course> list = new ArrayList<>();
            for(int j=0;j<200;j++){
                String name = nameDic.get(random.nextInt(nameDic.size()));
                Long coachId = coachDic.get(random.nextInt(coachDic.size()));
                String kind = kindDic.get(random.nextInt(kindDic.size()));
                Integer duration = durationDic.get(random.nextInt(durationDic.size()));
                Course course = Course.builder()
                        .name(name)
                        .coachId(coachId)
                        .kind(kind)
                        .duration(duration)
                        .image(image)
                        .build();
                list.add(course);
            }
            courseDao.batchInsertCourse(list);
        }
    }


    @Test
    public void test_batchInsertUserCourse(){
        List<Long> userIdList = Arrays.asList(2L,6L);
        Map<Long,String> coachNameDic = new HashMap<>();
        coachNameDic.put(1L,"A");
        coachNameDic.put(2L,"B");
        coachNameDic.put(3L,"C");
        coachNameDic.put(4L,"D");
        coachNameDic.put(5L,"E");
        coachNameDic.put(6L,"F");
        Random random = new Random();

        for(int i=0;i<200;i++){
            List<UserCourse> list = new ArrayList<>();
            for(int j=0;j<1000;j++){
                Long userId = userIdList.get(random.nextInt(userIdList.size()));
                Long courseId = (long) (random.nextInt(2000)+501);
                Long coachId = (long) (random.nextInt(6)+1);
                String coachName = coachNameDic.get(coachId);
                UserCourse userCourse = UserCourse.builder()
                        .userId(userId)
                        .courseId(courseId)
                        .coachId(coachId)
                        .coachName(coachName)
                        .build();
                list.add(userCourse);
            }
            userCourseDao.batchInsertUserCourse(list);
        }

    }

    @Test
    public void test_batchInsertUserCourseResult(){
        Long index = 1L;
        Random random = new Random();
        for(int i=0;i<1000;i++){
            List<UserCourseResult> list = new ArrayList<>();
            for(int j=0;j<1000;j++){
                Map<String,Object> map = new HashMap<>();
                map.put("avg_score", random.nextDouble());
                map.put("active_days", random.nextInt(365)+1);
                map.put("id", RandomStringUtils.random(10));
                map.put("avg_power", random.nextInt(200)+1);
                map.put("avg_speed", random.nextInt(100));
                map.put("calories", random.nextInt(1000)+10);

                UserCourseResult userCourseResult = UserCourseResult.builder()
                        .userCourseId(index++)
                        .score(new BigDecimal(random.nextInt(100) + (random.nextInt(100)*1.0)/100))
                        .duration(random.nextInt(6000))
                        .extras(JSON.toJSONString(map))
                        .build();
                list.add(userCourseResult);
            }
            userCourseResultDao.batchInsertUserCourseResult(list);
        }
    }

    @Test
    public void test_batchInsertGiftTake(){
        List<Long> userIdList = Arrays.asList(1L,2L,3L,4L,5L,6L);
        Set<String> set = new HashSet<>();
        Random random = new Random();
        Calendar calendar = Calendar.getInstance();
        long index = 1L;
        for(int i=0;i<15;i++){
            List<GiftTake> list = new ArrayList<>();
            for(int j=0;j<256;j++){
                Long userId = userIdList.get(random.nextInt(userIdList.size()));
                Long courseId = (long) (random.nextInt(3000) + 2001);
//                while (set.contains(userId + ":" + courseId)){
//                    userId = userIdList.get(random.nextInt(userIdList.size()));
//                    courseId = (long) (random.nextInt(2000));
//                }
                courseId = index++;
                if(index > 5620){
                    break;
                }
                set.add(userId + ":" + courseId);
                HashMap<String, Object> giftMap = new HashMap<>();
                giftMap.put("courseId", courseId);
                calendar.setTime(new Date());
                calendar.add(Calendar.DAY_OF_MONTH, random.nextInt(200));
                GiftTake giftTake = GiftTake.builder()
                        .userId(2L)
                        .gift(JSON.toJSONString(giftMap))
                        .expireTime(calendar.getTime())
                        .build();
                list.add(giftTake);
            }
            giftTakeDao.batchInsertGiftTake(list);
            if(index > 5620){
                break;
            }
        }


    }

}
