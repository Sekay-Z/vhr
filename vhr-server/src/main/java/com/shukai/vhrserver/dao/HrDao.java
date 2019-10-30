package com.shukai.vhrserver.dao;

import com.shukai.vhrserver.bean.Hr;
import com.shukai.vhrserver.bean.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface HrDao {
    Hr loadUserByUsername(String username);
    List<Role> getRolesByHrId(Long id);
    int hrReg(@Param("username") String username, @Param("password") String password);
    List<Hr> getHrsByKeywords(@Param("keywords") String keywords);
    int updateHr(Hr hr);
    int deleteRoleByHrId(Long hrId);
    int addRolesForHr(@Param("hrId") Long hrId, @Param("rids") Long[] rids);
    Hr getHrById(Long hrId);
    int deleteHr(Long hrId);
    List<Hr> getAllHr(@Param("currentId") Long currentId);
}
