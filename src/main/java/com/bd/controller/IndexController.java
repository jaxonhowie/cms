package com.bd.controller;

import com.bd.dao.mapper.MenuMapper;
import com.bd.dao.UserInfoMapper;
import com.bd.model.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Map;

/**
 * @author NiuJian
 * @date 2018/5/28
 */
@Controller
@RequestMapping("/")
public class IndexController {

    @Autowired
    UserInfoMapper userInfoMapper;


    @Autowired
    MenuMapper menuMapper;


    /**
     * 登录
     *
     * @param model
     * @param maps
     * @return
     */
    @RequestMapping("/login")
    public String login(Model model, Map<String, Object> maps) {
        return "login";
    }


    @RequestMapping("/index1")
    public String userLogin(Model model, Map<String, Object> map, @RequestParam(defaultValue = "") String loginName,
                            @RequestParam(defaultValue = "") String password) {
        UserInfo userInfo=userInfoMapper.selectByPassword(loginName,password);
        if (userInfo ==null) {
            map.put("error", "用户名或密码错误");
            return "login";
        }else
        {
            userInfo.setLstLoginTime(new Date());
            userInfoMapper.updateByPrimaryKey(userInfo);
            map.put("userinfo",userInfo);
            return "index";
        }
    }


//    /**
//     * 进入系统管理首页
//     * @param map
//     * @return
//     */
//    @RequestMapping("index")
//    public String index(ModelMap map, HttpSession session){
//        AdminUser user = (AdminUser) session.getAttribute("loginUser");
//        List<Menu> menus = menuMapper.selectByUser(user.getId());
//
//        map.put("treeMenu",menus);
//        return "index";
//    }

}
