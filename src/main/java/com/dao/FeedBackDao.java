package com.dao;

import com.entity.CoffeeFeedBack;

import java.util.List;

public interface FeedBackDao {

    /**
     * 新增意见反馈
     * @param coffeeFeedBack
     * @return
     */
    int insertFeedBack(CoffeeFeedBack coffeeFeedBack);

    /**
     * 查询意见反馈列表
     * @param coffeeFeedBack
     * @return
     */
    List<CoffeeFeedBack> findFeedBackList(CoffeeFeedBack coffeeFeedBack);

    /**
     * 查询意见反馈总数
     * @param coffeeFeedBack
     * @return
     */
    Integer selectCount(CoffeeFeedBack coffeeFeedBack);
}
