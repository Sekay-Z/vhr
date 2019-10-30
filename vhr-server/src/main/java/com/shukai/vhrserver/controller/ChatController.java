package com.shukai.vhrserver.controller;

import com.shukai.vhrserver.bean.Hr;
import com.shukai.vhrserver.bean.MsgContent;
import com.shukai.vhrserver.bean.RespBean;
import com.shukai.vhrserver.bean.SysMsg;
import com.shukai.vhrserver.service.HrServiceImpl;
import com.shukai.vhrserver.service.SysMsgServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/chat")
public class ChatController {
    @Autowired
    private HrServiceImpl hrService;
    @Autowired
    private SysMsgServiceImpl sysMsgService;
    @GetMapping("/hrs")
    public List<Hr> getAllHr(){
        return hrService.getAllHrExceptAdmin();
    }
    @PostMapping("/send")
    public RespBean sendNF(MsgContent msgContent){
        if(sysMsgService.sendMsg(msgContent)){
            return RespBean.ok("发送成功!");
        }else{
            return RespBean.error("发送失败!");
        }
    }
    @RequestMapping("/sysmsgs")
    public List<SysMsg> getSysMsg(@RequestParam(value = "page",defaultValue="1")Integer page,
                                   @RequestParam(value = "size",defaultValue = "10")Integer size){
        return sysMsgService.getSysMsgByPage(page,size);
    }
    @PutMapping("/markread")
    public RespBean markRead(Long flag) {
        if(sysMsgService.markRead(flag)){
            if(flag==-1){
                return RespBean.ok("multiple");
            }else{
                return RespBean.ok("single");
            }
        }else{
            if(flag==-1){
                return RespBean.error("multiple");
            }else{
                return RespBean.error("single");
            }
        }
    }
}
