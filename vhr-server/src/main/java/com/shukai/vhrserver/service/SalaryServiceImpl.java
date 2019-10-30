package com.shukai.vhrserver.service;

import com.shukai.vhrserver.bean.Salary;
import com.shukai.vhrserver.dao.SalaryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class SalaryServiceImpl implements SalaryService {
    @Autowired
    private SalaryDao salaryDao;
    @Override
    public int addSalary(Salary salary) {
        return salaryDao.addSalary(salary);
    }

    @Override
    public List<Salary> getAllSalary() {
        return salaryDao.getAllSalary();
    }

    @Override
    public int updateSalary(Salary salary) {
        return salaryDao.updateSalary(salary);
    }

    @Override
    public int deleteSalary(String ids) {
        String[] split = ids.split(",");
        return salaryDao.deleteSalary(split);
    }

    @Override
    public int updateEmpSalary(Integer sid, Long eid) {
        salaryDao.deleteSalaryByEid(eid);
        return salaryDao.addSidAndEid(sid,eid);
    }
}
