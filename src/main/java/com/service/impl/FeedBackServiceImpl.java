package com.service.impl;

import com.dao.FeedBackDao;
import com.entity.CoffeeFeedBack;
import com.service.FeedBackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("FeedBackService")
public class FeedBackServiceImpl implements FeedBackService {

    @Autowired
    private FeedBackDao feedBackDao;

    /**
     * 新增意见反馈
     * @param coffeeFeedBack
     * @return
     */
    @Override
    public int addFeedBack(CoffeeFeedBack coffeeFeedBack) {
        int result = feedBackDao.insertFeedBack(coffeeFeedBack);

        return result;
    }
}
