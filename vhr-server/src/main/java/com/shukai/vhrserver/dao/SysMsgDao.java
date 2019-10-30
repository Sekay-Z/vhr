package com.shukai.vhrserver.dao;

import com.shukai.vhrserver.bean.Hr;
import com.shukai.vhrserver.bean.MsgContent;
import com.shukai.vhrserver.bean.SysMsg;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysMsgDao {
    int sendMsg(MsgContent msg);
    int addMsgAllHr(@Param("hrs") List<Hr> hrs, @Param("mid") Long mid);
    List<SysMsg> getSysMsg(@Param("start") int start, @Param("size") Integer size, @Param("hrid") Long hrid);
    int markRead(@Param("mid") Long mid, @Param("hrid") Long hrid);
}
