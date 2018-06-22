package com.bd.service.impl;

import com.bd.common.Constants;
import com.bd.model.AdminUser;
import com.bd.model.Menu;
import com.bd.model.RoleMenu;
import com.bd.model.mapper.AdminUserMapper;
import com.bd.model.mapper.MenuMapper;
import com.bd.model.mapper.RoleMenuMapper;
import com.bd.service.RoleMenuService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * 角色相关权限业务业务接口实现类
 *
 * @author Administrator
 */
@Service
public class RoleMenuServiceImpl implements RoleMenuService {

    @Autowired
    private MenuMapper mapper;

    @Autowired
    private AdminUserMapper adminUserMapper;

    @Autowired
    private RoleMenuMapper roleMenuMapper;

    @Override
    public List<Menu> selectByRoleId(int id) {
        HashMap<Integer, ArrayList<Menu>> map = new HashMap<Integer, ArrayList<Menu>>();
        List<Menu> menus = mapper.selectByRoleId(id);
        for (Menu menu : menus) {
            int parentid = menu.getParentid();
            if (menu.getRoleid() != 0) {
                menu.setAdditionalParameters(new HashMap<String, Object>());
                menu.getAdditionalParameters().put("item-selected", true);
            }
            if (map.containsKey(parentid)) {
                map.get(parentid).add(menu);
            } else {
                ArrayList<Menu> temp = new ArrayList<Menu>();
                temp.add(menu);
                map.put(parentid, temp);
            }
        }
        for (Menu menu : menus) {
            int mid = menu.getId();
            if (map.containsKey(mid)) {
                menu.setType("folder");
                menu.setChildren(map.get(mid));
            } else {
                menu.setType("item");
            }
        }
        return map.get(0);
    }

    @Override
    public boolean updateRoleMenu(String ids, int roleid, int userid) {
        if (ids.length() > 0) {
            ids = ids.substring(0, ids.length() - 1);
        }
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("menuids", ids);
        map.put("roleid", roleid);
        map.put("userid", userid);

        String[] idss = StringUtils.split(ids, ",");

        for (int i = 0; i < idss.length; i++) {
            RoleMenu roleMenu = new RoleMenu();
            roleMenu.setMenuid(Integer.parseInt(idss[i]));
            roleMenu.setRoleid(roleid);
            roleMenu.setCreator(userid);
            roleMenu.setCreatetime(new Date());

            roleMenu.setFlag(Constants.ROLE_FLAG_TRUE);

            roleMenuMapper.insert(roleMenu);
        }

        //mapper.roleMenuUpdate(map);

        return true;
    }
}
