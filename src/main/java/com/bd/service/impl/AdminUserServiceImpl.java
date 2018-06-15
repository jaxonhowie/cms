package com.bd.service.impl;

import com.bd.model.AdminUser;
import com.bd.model.Role;
import com.bd.model.WebResult;
import com.bd.model.mapper.AdminUserMapper;
import com.bd.model.mapper.UserRoleMapper;
import com.bd.service.AdminUserService;
import com.bd.util.MD5Util;
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

    @Override
    public List<AdminUser> select(int page, int pageSize, String query) {
        return userMapper.selectByQuery((page - 1) * pageSize,pageSize,"%"+query+"%");
    }

    @Override
    public int selectCount(String query) {
        return userMapper.selectCountByName("%"+query+"%");
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
        user.setPsw(MD5Util.MD5(user.getPsw()));
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

    @Override
    public boolean updateRoleMenu(String ids, int userid, int creater) {
        if(ids.length() > 0){
            ids = ids.substring(0,ids.length()-1);
        }
        HashMap<String,Object> map = new HashMap<String, Object>();
        map.put("roleids",ids);
        map.put("creator",creater);
        map.put("userid",userid);
        userRoleMapper.userRoleUpdate(map);
        return true;
    }

    @Override
    public WebResult updatePass(int userId, String psw, String oldPsw) {
        AdminUser user = userMapper.selectByPrimaryKey(userId);
        if(user.getPsw().equalsIgnoreCase(MD5Util.MD5(oldPsw))){
            user.setUpdateuser(userId);
            user.setUpdatetime(new Date());
            user.setPsw(MD5Util.MD5(psw));
            if(userMapper.updateByPrimaryKeySelective(user) > 0){
                return WebResult.success();
            }else{
                return WebResult.unKnown();
            }
        }else{
            return WebResult.error("旧密码错误");
        }
    }
}
