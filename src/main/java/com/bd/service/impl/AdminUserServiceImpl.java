package com.bd.service.impl;

import com.bd.model.AdminUser;
import com.bd.model.Role;
import com.bd.model.UserRole;
import com.bd.model.WebResult;
import com.bd.model.mapper.AdminUserMapper;
import com.bd.model.mapper.UserRoleMapper;
import com.bd.service.AdminUserService;
import com.bd.util.MD5Util;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * 系统用户相关业务接口实现类
 *
 * @author niujian
 * @date 2017/3/21
 */
@Service
public class AdminUserServiceImpl implements AdminUserService {

    @Autowired
    private AdminUserMapper userMapper;
    @Autowired
    private UserRoleMapper userRoleMapper;

    Logger logger = LoggerFactory.getLogger(AdminUserServiceImpl.class);

    @Override
    public List<AdminUser> select(int page, int pageSize, String query) {
        return userMapper.selectByQuery((page - 1) * pageSize, pageSize, "%" + query + "%");
    }

    @Override
    public int selectCount(String query) {
        return userMapper.selectCountByName("%" + query + "%");
    }

    @Override
    public AdminUser login(String name, String pwd) {
        AdminUser temp = new AdminUser();
        temp.setName(name);
        temp.setPsw(MD5Util.MD5(pwd));
        return userMapper.selectOne(temp);
    }

    @Override
    public AdminUser selectById(int id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public boolean insert(AdminUser user) {
        logger.info("user is :"+user.toString());
        user.setPsw(MD5Util.MD5(user.getPsw()));
        user.setLogintime(new Date());
        return userMapper.insertSelective(user) > 0;
    }

    @Override
    public boolean update(AdminUser user) {
        user.setPsw(null);
        return userMapper.updateByPrimaryKeySelective(user) > 0;
    }

    @Transactional
    @Override
    public boolean delete(int id) {
        userMapper.deleteByPrimaryKey(id);
        userRoleMapper.deleteByUserId(id);
        return true;
    }

    @Override
    public List<Role> selectUserRole(int id) {
        List<Role> roles = userRoleMapper.selectByUserId(id);
        return roles;
    }

    //TODO 仅新增可以，更新还有bug
    @Override
    public boolean updateRoleMenu(String ids, int userid, int creater) {
        if (ids.length() > 0) {
            ids = ids.substring(0, ids.length() - 1);
        }
        String [] idss= StringUtils.split(ids,",");
        for (int i = 0; i < idss.length; i++) {

            UserRole userRole=new UserRole();
            userRole.setRoleid(Integer.parseInt(idss[i]));
            userRole.setUserid(userid);
            userRole.setCreator(creater);
            userRole.setCreatetime(new Date());
            userRoleMapper.insert(userRole);
            
        }

        return true;
    }

    @Override
    public WebResult updatePass(int userId, String psw, String oldPsw) {
        AdminUser user = userMapper.selectByPrimaryKey(userId);
        if (user.getPsw().equalsIgnoreCase(MD5Util.MD5(oldPsw))) {
            user.setUpdateuser(userId);
            user.setUpdatetime(new Date());
            user.setPsw(MD5Util.MD5(psw));
            if (userMapper.updateByPrimaryKeySelective(user) > 0) {
                return WebResult.success();
            } else {
                return WebResult.unKnown();
            }
        } else {
            return WebResult.error("旧密码错误");
        }
    }
}
