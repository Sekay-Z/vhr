package com.shukai.vhrserver;

import com.shukai.vhrserver.bean.Department;
import com.shukai.vhrserver.dao.DepartmentDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class VhrserverApplicationTests {
	@Autowired
	DepartmentDao departmentDao;


	@Test
	public void contextLoads() {
		Department department=new Department();
		department.setId((long) 94);
		department.setName("sss");
		departmentDao.deleteDep(department);
		System.out.println(department.getResult());
	}

}
