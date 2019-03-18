package com.dao;

import com.entity.CoffeeFeedBack;

public interface FeedBackDao {

    /**
     * 新增意见反馈
     * @param coffeeFeedBack
     * @return
     */
    int insertFeedBack(CoffeeFeedBack coffeeFeedBack);
}
