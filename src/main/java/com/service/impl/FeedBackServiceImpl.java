package com.service.impl;

import com.common.ServerResponse;
import com.dao.FeedBackDao;
import com.entity.CoffeeFeedBack;
import com.github.pagehelper.PageHelper;
import com.service.FeedBackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    /**
     * 意见反馈列表
     * @param coffeeFeedBack
     * @return
     */
    @Override
    public ServerResponse<List<CoffeeFeedBack>> findFeedBackList(CoffeeFeedBack coffeeFeedBack) {

        Integer count = feedBackDao.selectCount(coffeeFeedBack);
        PageHelper.startPage(coffeeFeedBack.getPageNum(),coffeeFeedBack.getPageSize());
        List<CoffeeFeedBack> list = feedBackDao.findFeedBackList(coffeeFeedBack);
        if(list == null){
            return ServerResponse.createByErrorMessage("查询意见反馈列表为空");
        }
        else{
            return ServerResponse.createBySuccess(count.toString(),list);
        }
    }
}
