package com.shukai.vhrserver.service;

import com.shukai.vhrserver.bean.Department;
import com.shukai.vhrserver.dao.DepartmentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class DepartmentServiceImpl implements DepartmentSerrvice {
    @Autowired
    private DepartmentDao departmentDao;
    @Override
    public int addDep(Department department) {
        department.setEnabled(true);
        departmentDao.addDep(department);
        return department.getResult();
    }

    @Override
    public int deleteDep(Long did) {
        Department department=new Department();
        department.setId(did);
        departmentDao.deleteDep(department);
        return department.getResult();
    }

    @Override
    public List<Department> getDepByPid(Long pid) {
        return departmentDao.getDepByPid(pid);
    }

    @Override
    public List<Department> getAllDeps() {
        return departmentDao.getAllDeps();
    }
}
