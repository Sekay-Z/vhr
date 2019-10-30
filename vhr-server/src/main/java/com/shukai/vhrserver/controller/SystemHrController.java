package com.shukai.vhrserver.controller;

import com.shukai.vhrserver.bean.Hr;
import com.shukai.vhrserver.bean.RespBean;
import com.shukai.vhrserver.bean.Role;
import com.shukai.vhrserver.service.HrService;
import com.shukai.vhrserver.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/system/hr")
public class SystemHrController {
    @Autowired
    HrService hrService;
    @Autowired
    RoleService roleService;
    @GetMapping("/id/{hrId}")
    public Hr getHrById(@PathVariable("hrId") Long hrId) {
        return hrService.getHrById(hrId);
    }
    @DeleteMapping("/{hrId}")
    public RespBean deleteHr(@PathVariable("hrId") Long hrId) {
        if (hrService.deleteHr(hrId) == 1) {
            return RespBean.ok("删除成功!");
        }
        return RespBean.error("删除失败!");
    }
    @PutMapping("/")
    public RespBean updateHr(Hr hr) {
        if (hrService.updateHr(hr) == 1) {
            return RespBean.ok("更新成功!");
        }
        return RespBean.error("更新失败!");
    }
    @PutMapping("/roles")
    public RespBean updateHrRoles(Long hrId, Long[] rids) {
        if (hrService.updateHrRoles(hrId, rids) == rids.length) {
            return RespBean.ok("更新成功!");
        }
        return RespBean.error("更新失败!");
    }
    @GetMapping("/roles")
    public List<Role> allRoles() {
        return roleService.roles();
    }
    @GetMapping("/{keywords}")
    public List<Hr> getHrsByKeywords(@PathVariable(value = "keywords",required = false) String keywords) {
        return hrService.getHrsByKeywords(keywords);
    }
    @PostMapping("/hr/reg")
    public RespBean hrReg(String username, String password) {
        int i= hrService.hrReg(username, password);
        if(i==1){
            return RespBean.ok("注册成功！");
        }else if(i==-1){
            return RespBean.error("用户名重复！");
        }else{
            return RespBean.error("注册失败！");
        }
    }
}
