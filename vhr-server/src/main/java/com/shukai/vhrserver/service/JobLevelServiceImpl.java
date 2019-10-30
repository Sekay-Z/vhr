package com.shukai.vhrserver.service;

import com.shukai.vhrserver.bean.JobLevel;
import com.shukai.vhrserver.dao.JobLevelDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class JobLevelServiceImpl implements JobLevelService {
    @Autowired
    private JobLevelDao jobLevelDao;
    @Override
    public int addJobLevel(JobLevel jobLevel) {
        if (jobLevelDao.getJobLevelByName(jobLevel.getName()) != null) {
            return -1;
        }
        return jobLevelDao.addJobLevel(jobLevel);
    }

    @Override
    public List<JobLevel> getAllJobLevels() {
        return jobLevelDao.getAllJobLevels();
    }

    @Override
    public boolean deleteJobLevelById(String ids) {
        String[] split = ids.split(",");
        return jobLevelDao.deleteJobLevelById(split)==split.length;
    }

    @Override
    public int updateJobLevel(JobLevel jobLevel) {
        return jobLevelDao.updateJobLevel(jobLevel);
    }
}
