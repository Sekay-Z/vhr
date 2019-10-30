package com.shukai.vhrserver.service;

import com.shukai.vhrserver.bean.Menu;
import com.shukai.vhrserver.dao.MenuDao;
import com.shukai.vhrserver.util.HrUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class MenuServiceImpl implements MenuService {
    @Autowired
    private MenuDao menuDao;
    @Override
    public List<Menu> getAllMenu() {
        return menuDao.getAllMenu();
    }

    @Override
    public List<Menu> getMenusByHrId() {
        return menuDao.getMenusByHrId(HrUtils.getCurrentHr().getId());
    }

    @Override
    public List<Menu> menuTree() {
        return menuDao.menuTree();
    }

    @Override
    public List<Long> getMidByRid(Long rid) {
        return menuDao.getMidByRid(rid);
    }


    @Override
    public List<Menu> getMenuByRid(Long[] rids) {
        return menuDao.getMenuByRid(rids);
    }

}
