package com.shukai.vhrserver.controller;

import com.shukai.vhrserver.bean.RespBean;
import com.shukai.vhrserver.bean.Salary;
import com.shukai.vhrserver.service.EmpServiceImpl;
import com.shukai.vhrserver.service.SalaryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/salary/sob")
public class SalaryController {
    @Autowired
    private SalaryServiceImpl salaryService;
    @Autowired
    private EmpServiceImpl empService;
    @GetMapping("/salary")
    public List<Salary> salaries(){
        return salaryService.getAllSalary();
    }
    @PostMapping("/salary")
    public RespBean addSalaryCfg(Salary salary) {
        if(salaryService.addSalary(salary)==1){
            return RespBean.ok("添加成功!");
        }else{
            return RespBean.error("添加失败!");
        }
    }
    @PutMapping("/salary")
    public RespBean updateSalary(Salary salary) {
        if (salaryService.updateSalary(salary) == 1) {
            return RespBean.ok("更新成功!");
        }
        return RespBean.error("更新失败!");
    }
    @DeleteMapping("/salary/{ids}")
    public RespBean deleteSalary(@PathVariable String ids) {
        if(salaryService.deleteSalary(ids)>=1){
            return RespBean.ok("删除成功!");
        }else{
            return RespBean.error("删除失败!");
        }
    }
}
