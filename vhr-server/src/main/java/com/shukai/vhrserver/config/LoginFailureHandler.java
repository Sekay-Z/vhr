package com.shukai.vhrserver.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.shukai.vhrserver.bean.RespBean;
import org.springframework.security.authentication.*;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Component
public class LoginFailureHandler implements AuthenticationFailureHandler {
    @Override
    public void onAuthenticationFailure(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
        httpServletResponse.setContentType("application/json;charset=utf-8");
        httpServletResponse.setHeader("Access-Control-Allow-Origin", "*");
        RespBean respBean=null;
        if(e instanceof BadCredentialsException||e instanceof UsernameNotFoundException){
            respBean = RespBean.error("账户名或密码错误！");
        }else if(e instanceof LockedException){
            respBean=RespBean.error("账户被锁定，请联系管理员！");
        }else if(e instanceof CredentialsExpiredException){
            respBean = RespBean.error("密码过期，请联系管理员！");
        } else if (e instanceof AccountExpiredException) {
            respBean = RespBean.error("账户过期，请联系管理员!");
        } else if (e instanceof DisabledException) {
            respBean = RespBean.error("账户被禁用，请联系管理员!");
        } else {
            respBean = RespBean.error("登录失败!");
        }
        respBean.setStatus(401);
        ObjectMapper objectMapper=new ObjectMapper();
        PrintWriter writer = httpServletResponse.getWriter();
        writer.write(objectMapper.writeValueAsString(respBean));
        writer.flush();
        writer.close();
    }
}
