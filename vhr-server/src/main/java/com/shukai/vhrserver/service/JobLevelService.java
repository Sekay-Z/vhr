package com.shukai.vhrserver.service;

import com.shukai.vhrserver.bean.JobLevel;

import java.util.List;

public interface JobLevelService {
    public int addJobLevel(JobLevel jobLevel);
    public List<JobLevel> getAllJobLevels();
    public boolean deleteJobLevelById(String ids);
    public int updateJobLevel(JobLevel jobLevel);
}
