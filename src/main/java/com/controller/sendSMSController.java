package com.controller;

import com.common.HttpRequest;
import com.common.ServerResponse;
import com.entity.CoffeeUser;
import com.entity.PhoneDto;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Random;

@RestController
@CrossOrigin
@RequestMapping(value = "/api/send")
public class sendSMSController {

    @Autowired
    private UserService userService;

    /**
     * 发送短信验证码
     * @param coffeeUser
     * @param request
     * @return
     * @throws UnsupportedEncodingException
     */
    @RequestMapping(value = "/sendMsm.do",method = RequestMethod.POST)
    public ServerResponse<Boolean> register(@RequestBody CoffeeUser coffeeUser, HttpServletRequest request) throws UnsupportedEncodingException {
        System.out.println(coffeeUser.getUserPhone());

        Random random = new Random();
        String codeKey="";
        for (int i=0;i<6;i++)
        {
            codeKey+=random.nextInt(10);
        }
        System.out.println(codeKey);
        //手机号  可以多个手机号
        String phones = coffeeUser.getUserPhone();
        String content = URLEncoder.encode("【咖啡预定App】您的验证码是"+ codeKey,"UTF-8");
        String postData = "type=send&username=18242094436&password=DA53683DCC2BC2F42A238F1B2F3DBB1A&gwid=dceb8cfa&rece=json&mobile="+phones+"&message="+content+"";
        String url="http://jk.106api.cn/smsUTF8.aspx";
        //发送并把结果赋给result,返回一个XML信息,解析xml 信息判断
        String result= HttpRequest.sendPost(url,postData);

        JsonObject userJsonObj = new JsonParser().parse(result).getAsJsonObject();
        String status = userJsonObj .get("returnstatus").toString().replaceAll("\"", "");
        String code = userJsonObj .get("code").toString().replaceAll("\"", "");

        HttpSession session = request.getSession(); //设置session
        //session.setAttribute(phone+"code", code);    //将短信验证码放到session中保存，前面加phone的目的是做唯一标识
        session.setAttribute("codeKey", codeKey);
        session.setAttribute("phone", phones);
        session.setMaxInactiveInterval(60 * 3); //指定缓存释放时间

        System.out.println(session.getAttribute("codeKey"));
        System.out.println(session.getAttribute("phone"));
        return ServerResponse.createBySuccessMessage("发送成功");
    }



    /**
     * 用户手机号、验证码登录
     * @param phoneDto
     * @return
     */
    @RequestMapping(value = "/loginValidate.do",method = RequestMethod.POST)
    public ServerResponse<CoffeeUser> loginValidate(@RequestBody PhoneDto phoneDto, HttpServletRequest request) {
        HttpSession session = request.getSession();//设置session
        String phone =(String) session.getAttribute("phone");
        String codeKey =(String) session.getAttribute("codeKey");

        if(phone==null || codeKey==null){
            return ServerResponse.createByErrorMessage("验证码已过期，请重新获取");
        }

        System.out.println(phone);
        System.out.println(codeKey);
        if(!phone.equals(phoneDto.getPhone())){
            return ServerResponse.createByErrorMessage("两次输入的手机号不一致");
        }
        if(!codeKey.equals(phoneDto.getValidate())){
            return ServerResponse.createByErrorMessage("验证码错误");
        }
        ServerResponse<CoffeeUser> result=userService.loginByValidate(phoneDto);
        if(result != null){
            return result;
        }
        else{
            return ServerResponse.createByErrorMessage("登录失败");
        }
    }

//    @RequestMapping(value = "/register.do",method = RequestMethod.POST)
//    public ServerResponse<CoffeeUser> register(@RequestBody PhoneDto phoneDto, HttpServletRequest request) {
//        HttpSession session = request.getSession();//设置session
//        String phone =(String) session.getAttribute("phone");
//        String codeKey =(String) session.getAttribute("codeKey");
//
//        if(phone==null || codeKey==null){
//            return ServerResponse.createByErrorMessage("验证码已过期，请重新获取");
//        }
//
//        System.out.println(phone);
//        System.out.println(codeKey);
//        System.out.println(phoneDto.getPassword());
//        if(!phone.equals(phoneDto.getPhone())){
//            return ServerResponse.createByErrorMessage("两次输入的手机号不一致");
//        }
//        if(!codeKey.equals(phoneDto.getValidate())){
//            return ServerResponse.createByErrorMessage("验证码错误");
//        }
//        CoffeeUser coffeeUser = new CoffeeUser();
//        coffeeUser.setUserPhone(phoneDto.getPhone());
//        coffeeUser.setUserPassword(phoneDto.getPassword());
//        System.out.println(coffeeUser);
//        ServerResponse<CoffeeUser> result = userService.register(coffeeUser);
//        if(result != null){
//            return result;
//        }
//        else{
//            return ServerResponse.createByErrorMessage("注册失败");
//        }
//    }


}
