package com.shukai.vhrserver.service;

import com.shukai.vhrserver.bean.Hr;

import java.util.List;

public interface HrService {
    public int hrReg(String username, String password);
    public List<Hr> getHrsByKeywords(String keywords);
    public int updateHr(Hr hr);
    public int updateHrRoles(Long hrId, Long[] rids);
    public Hr getHrById(Long hrId);
    public int deleteHr(Long hrId);
    public List<Hr> getAllHrExceptAdmin();
    public List<Hr> getAllHr();
}
