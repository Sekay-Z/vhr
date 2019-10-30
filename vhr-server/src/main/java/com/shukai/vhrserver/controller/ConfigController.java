package com.shukai.vhrserver.controller;

import com.shukai.vhrserver.bean.Hr;
import com.shukai.vhrserver.bean.Menu;
import com.shukai.vhrserver.service.MenuServiceImpl;
import com.shukai.vhrserver.util.HrUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/config")
public class ConfigController {
    @Autowired
    private MenuServiceImpl menuService;
    @GetMapping("/sysmenu")
    public List<Menu> sysmenu() {
        return menuService.getMenusByHrId();
    }
    @GetMapping("/hr")
    public Hr currentUser() {
        return HrUtils.getCurrentHr();
    }
}
