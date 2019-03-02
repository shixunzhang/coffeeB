package com.dao;

import com.entity.CoffeeOrder;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderDao {

    List<CoffeeOrder> selectList(@Param("userId") int userId,@Param("finishFlag") int finishFlag);
}
