package com.shukai.vhrserver.dao;

import com.shukai.vhrserver.bean.Department;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DepartmentDao {
    void addDep(@Param("dep") Department department);
    void deleteDep(@Param("dep") Department department);
    List<Department> getDepByPid(Long pid);
    List<Department> getAllDeps();
}
