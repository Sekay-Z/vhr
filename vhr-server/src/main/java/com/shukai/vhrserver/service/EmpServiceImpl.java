package com.shukai.vhrserver.service;

import com.shukai.vhrserver.bean.Employee;
import com.shukai.vhrserver.bean.Nation;
import com.shukai.vhrserver.bean.PoliticsStatus;
import com.shukai.vhrserver.dao.EmpDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
@Service
@Transactional
public class EmpServiceImpl implements EmpService {
    @Autowired
    private EmpDao empDao;
    SimpleDateFormat yearFormat=new SimpleDateFormat("yyyy");
    SimpleDateFormat monthFormat=new SimpleDateFormat("MM");
    SimpleDateFormat birthdayFormat=new SimpleDateFormat("yyyy-MM-dd");
    DecimalFormat decimalFormat = new DecimalFormat("##.00");

    @Override
    public List<Nation> getAllNations() {
        return empDao.getAllNations();
    }

    @Override
    public List<PoliticsStatus> getAllPolitics() {
        return empDao.getAllPolitics();
    }

    @Override
    public int addEmp(Employee employee) {
        Date beginContract = employee.getBeginContract();
        Date endContract = employee.getEndContract();
        double contractTerm = (Double.parseDouble(yearFormat.format(endContract))
                - Double.parseDouble(yearFormat.format(beginContract))) * 12
                + Double.parseDouble(monthFormat.format(endContract))
                - Double.parseDouble(monthFormat.format(beginContract));
        employee.setContractTerm(Double.parseDouble(decimalFormat.format(contractTerm/12)));
        return empDao.addEmp(employee);
    }

    @Override
    public Long getMaxWorkID() {
        Long maxWorkID = empDao.getMaxWorkID();
        return maxWorkID==null?0:maxWorkID;
    }

    @Override
    public List<Employee> getEmployeeByPage(Integer page, Integer size, String keywords, Long politicId, Long nationId, Long posId, Long jobLevelId, String engageForm, Long departmentId, String beginDateScope){
        int start=(page-1)*size;
        Date startBeginDate=null;
        Date endBeginDate=null;
        if(beginDateScope!=null&&beginDateScope.contains(",")){
            String[] split = beginDateScope.split(",");
            try {
                startBeginDate = birthdayFormat.parse(split[0]);
                endBeginDate = birthdayFormat.parse(split[1]);
            }catch (ParseException e){
                e.printStackTrace();
            }
        }
        return empDao.getEmployeeByPage(start,size,keywords,politicId,nationId,posId,jobLevelId,engageForm,departmentId,startBeginDate,endBeginDate);
    }

    @Override
    public Long getCountByKeywords(String keywords, Long politicId, Long nationId, Long posId, Long jobLevelId, String engageForm, Long departmentId, String beginDateScope) {
        Date startBeginDate = null;
        Date endBeginDate = null;
        if (beginDateScope != null && beginDateScope.contains(",")) {
            try {
                String[] split = beginDateScope.split(",");
                startBeginDate = birthdayFormat.parse(split[0]);
                endBeginDate = birthdayFormat.parse(split[1]);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return empDao.getCountByKeywords(keywords, politicId, nationId, posId, jobLevelId, engageForm, departmentId, startBeginDate, endBeginDate);
    }

    @Override
    public int updateEmp(Employee employee) {
        Date beginContract = employee.getBeginContract();
        Date endContract = employee.getEndContract();
        Double contractTerm = (Double.parseDouble(yearFormat.format(endContract))
                - Double.parseDouble(yearFormat.format(beginContract))) * 12
                + Double.parseDouble(monthFormat.format(endContract))
                - Double.parseDouble(monthFormat.format(beginContract));
        employee.setContractTerm(Double.parseDouble(decimalFormat.format(contractTerm / 12)));
        return empDao.updateEmp(employee);
    }

    @Override
    public boolean deleteEmpById(String ids) {
        String[] split = ids.split(",");
        return empDao.deleteEmpById(split)==split.length;
    }

    @Override
    public List<Employee> getAllEmployees() {
        return empDao.getEmployeeByPage(null, null, "", null, null, null, null, null, null, null, null);
    }

    @Override
    public int addEmps(List<Employee> emps) {
        return empDao.addEmps(emps);
    }

    @Override
    public List<Employee> getEmployeeByPageShort(Integer page, Integer size) {
        int start=(page-1)*size;
        return empDao.getEmployeeByPageShort(start,size);
    }
}
