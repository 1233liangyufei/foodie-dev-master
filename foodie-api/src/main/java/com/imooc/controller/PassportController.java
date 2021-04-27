package com.imooc.controller;

import com.imooc.service.StuService;
import com.imooc.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;


@RestController
@RequestMapping("passport")
public class PassportController {

    @Autowired
    private UserService userService;

    @GetMapping("/usernameIsExist")
    public int usernameIsExist(@RequestParam String username){
        //1.判断入参不能为空
        if(StringUtils.isBlank(username)){
            return 500;
        }
        //2。查找注册的用户名是否存在
        boolean isExist = userService.queryUsernameIsExist(username);
        //System.out.println(isExist+"isExist");
        if(isExist){
            return 500;
        }
        //3.请求成功，用户名没有重复
        return 200;
    }


}
