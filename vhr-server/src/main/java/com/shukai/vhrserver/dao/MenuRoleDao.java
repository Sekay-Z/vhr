package com.shukai.vhrserver.dao;

import org.apache.ibatis.annotations.Param;

public interface MenuRoleDao {
    int deleteMenuByRid(@Param("rid") Long rid);
    int addMenu(@Param("rid") Long rid, @Param("mids") Long[] mids);
}
