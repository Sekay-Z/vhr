package com.shukai.vhrserver.service;

import com.shukai.vhrserver.bean.Role;
import com.shukai.vhrserver.dao.RoleDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleDao roleDao;
    @Override
    public List<Role> roles() {
        return roleDao.roles();
    }

    @Override
    public int addNewRole(String role, String roleZh) {
        if(!role.startsWith("ROLE_")){
            role="ROLE_"+role;
        }
        return roleDao.addNewRole(role,roleZh);
    }

    @Override
    public int deleteRoleById(Long rid) {
        return roleDao.deleteRoleById(rid);
    }
}
