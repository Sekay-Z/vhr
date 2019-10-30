package com.shukai.vhrserver.service;

import com.shukai.vhrserver.bean.Salary;

import java.util.List;

public interface SalaryService {
    public int addSalary(Salary salary);
    public List<Salary> getAllSalary();
    public int updateSalary(Salary salary);
    public int deleteSalary(String ids);
    public int updateEmpSalary(Integer sid, Long eid);
}
