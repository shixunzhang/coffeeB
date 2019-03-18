package com.service;

import com.entity.CoffeeFeedBack;

public interface FeedBackService {

    /**
     * 新增意见反馈
     * @param coffeeFeedBack
     * @return
     */
    int addFeedBack(CoffeeFeedBack coffeeFeedBack);
}
