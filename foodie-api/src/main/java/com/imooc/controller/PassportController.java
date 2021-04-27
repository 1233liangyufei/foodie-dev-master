package com.imooc.controller;

import com.imooc.service.StuService;
import com.imooc.service.UserService;
import com.imooc.utils.IMOOCJSONResult;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;


@RestController
@RequestMapping("passport")
public class PassportController {

    @Autowired
    private UserService userService;

    @GetMapping("/usernameIsExist")
    public IMOOCJSONResult usernameIsExist(@RequestParam String username){
        //1.判断入参不能为空
        if(StringUtils.isBlank(username)){
            return IMOOCJSONResult.errorMsg("用户名不能为空");
        }
        //2。查找注册的用户名是否存在
        boolean isExist = userService.queryUsernameIsExist(username);
        //System.out.println(isExist+"isExist");
        if(isExist){
            return IMOOCJSONResult.errorMsg("该用户已存在");
        }
        //3.请求成功，用户名没有重复
        return IMOOCJSONResult.ok();
    }


}