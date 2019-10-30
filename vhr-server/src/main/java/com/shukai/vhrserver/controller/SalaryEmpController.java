package com.shukai.vhrserver.controller;

import com.shukai.vhrserver.bean.Employee;
import com.shukai.vhrserver.bean.RespBean;
import com.shukai.vhrserver.bean.Salary;
import com.shukai.vhrserver.service.EmpService;
import com.shukai.vhrserver.service.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/salary/sobcfg")
public class SalaryEmpController {
    @Autowired
    private SalaryService salaryService;
    @Autowired
    private EmpService empService;
    @PutMapping("/")
    public RespBean updateEmpSalary(Integer sid, Long eid) {
        if(salaryService.updateEmpSalary(sid,eid)==1){
            return RespBean.ok("修改成功!");
        }else{
            return RespBean.error("修改失败!");
        }
    }
    @GetMapping("/salaries")
    public List<Salary> salaries() {
        return salaryService.getAllSalary();
    }
    @GetMapping("/emp")
    public Map<String, Object> getEmployeeByPage(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer size) {
        Map<String,Object> map=new HashMap<>();
        List<Employee> empList = empService.getEmployeeByPageShort(page, size);
        Long count = empService.getCountByKeywords("", null, null, null, null, null, null, null);
        map.put("emps",empList);
        map.put("count",count);
        return map;
    }
}
