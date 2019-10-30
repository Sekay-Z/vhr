package com.shukai.vhrserver.service;

import com.shukai.vhrserver.bean.Employee;
import com.shukai.vhrserver.bean.Nation;
import com.shukai.vhrserver.bean.PoliticsStatus;

import java.text.ParseException;
import java.util.List;

public interface EmpService {
    public List<Nation> getAllNations();
    public List<PoliticsStatus> getAllPolitics();
    public int addEmp(Employee employee);
    public Long getMaxWorkID();
    public List<Employee> getEmployeeByPage(Integer page, Integer size, String keywords, Long politicId, Long nationId, Long posId, Long jobLevelId, String engageForm, Long departmentId, String beginDateScope);
    public Long getCountByKeywords(String keywords, Long politicId, Long nationId, Long posId, Long jobLevelId, String engageForm, Long departmentId, String beginDateScope);
    public int updateEmp(Employee employee);
    public boolean deleteEmpById(String ids);
    public List<Employee> getAllEmployees();
    public int addEmps(List<Employee> emps);
    public List<Employee> getEmployeeByPageShort(Integer page, Integer size);
}
