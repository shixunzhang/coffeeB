package com.service;

import com.common.ServerResponse;
import com.entity.CoffeeFeedBack;

import java.util.List;

public interface FeedBackService {

    /**
     * 新增意见反馈
     * @param coffeeFeedBack
     * @return
     */
    int addFeedBack(CoffeeFeedBack coffeeFeedBack);

    /**
     * 查询意见反馈列表
     * @param coffeeFeedBack
     * @return
     */
    ServerResponse<List<CoffeeFeedBack>> findFeedBackList(CoffeeFeedBack coffeeFeedBack);
}
