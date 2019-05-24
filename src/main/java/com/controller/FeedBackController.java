package com.controller;

import com.common.ServerResponse;
import com.entity.CoffeeFeedBack;
import com.service.FeedBackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/api/feedback")
public class FeedBackController {

    @Autowired
    private FeedBackService feedBackService;


    @RequestMapping(value = "/list.do",method = RequestMethod.POST)
    public ServerResponse<List<CoffeeFeedBack>> selectList(@RequestBody CoffeeFeedBack coffeeFeedBack) {
        ServerResponse<List<CoffeeFeedBack>> result = feedBackService.findFeedBackList(coffeeFeedBack);
        if(result != null){
            return result;
        }
        else{
            return ServerResponse.createByErrorMessage("查询意见反馈列表失败");
        }
    }


    /**
     * 新增意见反馈
     * @param coffeeFeedBack
     * @return
     */
    @RequestMapping(value = "/increase.do",method = RequestMethod.POST)
    public ServerResponse<Integer> addFeedBack(@RequestBody CoffeeFeedBack coffeeFeedBack){
        int result = feedBackService.addFeedBack(coffeeFeedBack);
        if(result==1){
            return ServerResponse.createBySuccessMessage("加入意见反馈成功");
        }
        else{
            return ServerResponse.createByErrorMessage("加入意见反馈失败");
        }
    }
}
