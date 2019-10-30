package com.shukai.vhrserver.service;

import com.shukai.vhrserver.bean.Hr;
import com.shukai.vhrserver.bean.RespBean;
import com.shukai.vhrserver.dao.HrDao;
import com.shukai.vhrserver.util.HrUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
@Service
@Transactional
public class HrServiceImpl implements HrService,UserDetailsService {
    @Autowired
    private HrDao hrDao;
    @Override
    public int hrReg(String username, String password) {
        Hr hr = hrDao.loadUserByUsername(username);
        if(hr!=null){
            return -1;
        }
        BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
        String encode = encoder.encode(password);
        return hrDao.hrReg(username,encode);
    }

    @Override
    public List<Hr> getHrsByKeywords(String keywords) {
        return hrDao.getHrsByKeywords(keywords);
    }

    @Override
    public int updateHr(Hr hr) {
        return hrDao.updateHr(hr);
    }

    @Override
    public int updateHrRoles(Long hrId, Long[] rids) {
        int i = hrDao.deleteRoleByHrId(hrId);
        return hrDao.addRolesForHr(hrId,rids);
    }

    @Override
    public Hr getHrById(Long hrId) {
        return hrDao.getHrById(hrId);
    }

    @Override
    public int deleteHr(Long hrId) {
        return hrDao.deleteHr(hrId);
    }

    @Override
    public List<Hr> getAllHrExceptAdmin() {
        return hrDao.getAllHr(HrUtils.getCurrentHr().getId());
    }

    @Override
    public List<Hr> getAllHr() {
        return hrDao.getAllHr(null);
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Hr hr = hrDao.loadUserByUsername(s);
        if(hr==null){
            throw new UsernameNotFoundException("用户名不对！");
        }
        return hr;
    }
}
