package com.shukai.vhrserver.service;

import com.shukai.vhrserver.bean.Role;

import java.util.List;

public interface RoleService {
    public List<Role> roles();
    public int addNewRole(String role, String roleZh);
    public int deleteRoleById(Long rid);
}
