package com.test.dao;

import com.test.entity.GiftTake;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface GiftTakeDao {

    void batchInsertGiftTake(@Param("list") List<GiftTake> list);

}
