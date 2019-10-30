package com.shukai.vhrserver.service;

import com.shukai.vhrserver.bean.MsgContent;
import com.shukai.vhrserver.bean.SysMsg;

import java.util.List;

public interface SysMsgService {
    public boolean sendMsg(MsgContent msg);
    public List<SysMsg> getSysMsgByPage(Integer page, Integer size);
    public boolean markRead(Long flag);
}
