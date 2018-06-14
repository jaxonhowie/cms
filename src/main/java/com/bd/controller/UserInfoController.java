package com.bd.controller;

import com.bd.dao.UserInfoMapper;
import com.bd.model.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author NiuJian
 * @date 2018/6/14
 */

@RestController
public class UserInfoController {


    @Autowired
    UserInfoMapper userInfoMapper;

    @RequestMapping("/getUser")
    public UserInfo getUserInfo()
    {
        return userInfoMapper.selectByPrimaryKey("1");
    }

}
