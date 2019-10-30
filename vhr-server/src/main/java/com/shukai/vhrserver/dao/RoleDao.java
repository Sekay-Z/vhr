package com.shukai.vhrserver.dao;

import com.shukai.vhrserver.bean.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoleDao {
    List<Role> roles();
    int addNewRole(@Param("role") String role, @Param("roleZh") String roleZh);
    int deleteRoleById(Long rid);
}
