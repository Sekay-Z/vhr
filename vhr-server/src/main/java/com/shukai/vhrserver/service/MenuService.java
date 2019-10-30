package com.shukai.vhrserver.service;

import com.shukai.vhrserver.bean.Menu;

import java.util.List;

public interface MenuService {
    public List<Menu> getAllMenu();
    public List<Menu> getMenusByHrId();
    public List<Menu> menuTree();
    public List<Long> getMidByRid(Long rid);
    public List<Menu> getMenuByRid(Long[] rids);
}
