package com.shukai.vhrserver.dao;

import com.shukai.vhrserver.bean.Menu;

import java.util.List;

public interface MenuDao {
    List<Menu> getAllMenu();
    List<Menu> getMenusByHrId(Long hrId);
    List<Menu> menuTree();
    List<Long> getMidByRid(Long rid);
    List<Menu> getMenuByRid(Long[] rids);
}
