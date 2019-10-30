package com.shukai.vhrserver.controller;

import com.shukai.vhrserver.bean.Department;
import com.shukai.vhrserver.service.DepartmentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/salary/table")
public class SalaryTableController {
    @Autowired
    private DepartmentServiceImpl departmentService;
    @RequestMapping("/deps")
    public List<Department> departments() {
        return departmentService.getAllDeps();
    }
}
