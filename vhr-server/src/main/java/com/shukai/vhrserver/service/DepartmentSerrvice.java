package com.shukai.vhrserver.service;

import com.shukai.vhrserver.bean.Department;

import java.util.List;

public interface DepartmentSerrvice {
    public int addDep(Department department);
    public int deleteDep(Long did);
    public List<Department> getDepByPid(Long pid);
    public List<Department> getAllDeps();
}
