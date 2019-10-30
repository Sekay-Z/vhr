package com.shukai.vhrserver.service;

import com.shukai.vhrserver.bean.Hr;
import com.shukai.vhrserver.bean.MsgContent;
import com.shukai.vhrserver.bean.SysMsg;
import com.shukai.vhrserver.dao.SysMsgDao;
import com.shukai.vhrserver.util.HrUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class SysMsgServiceImpl implements SysMsgService {
    @Autowired
    private SysMsgDao sysMsgDao;
    @Autowired
    HrService hrService;

    @Override
    @PreAuthorize("hasRole('ROLE_admin')")
    public boolean sendMsg(MsgContent msg) {
        sysMsgDao.sendMsg(msg);
        List<Hr> allHr = hrService.getAllHr();
        int result = sysMsgDao.addMsgAllHr(allHr, msg.getId());
        return result==allHr.size();
    }

    @Override
    public List<SysMsg> getSysMsgByPage(Integer page, Integer size) {
        int start=(page-1)*size;
        return sysMsgDao.getSysMsg(start,size,HrUtils.getCurrentHr().getId());
    }

    @Override
    public boolean markRead(Long mid) {
        if(mid!=-1){
            return sysMsgDao.markRead(mid, HrUtils.getCurrentHr().getId())==1;
        }
        sysMsgDao.markRead(mid,HrUtils.getCurrentHr().getId());
        return true;
    }
}
