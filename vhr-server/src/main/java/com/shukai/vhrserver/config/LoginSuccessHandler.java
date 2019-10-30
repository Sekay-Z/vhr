package com.shukai.vhrserver.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.shukai.vhrserver.bean.RespBean;
import com.shukai.vhrserver.util.HrUtils;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Component
public class LoginSuccessHandler implements AuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        httpServletResponse.setContentType("application/json;charset=utf-8");
        httpServletResponse.setHeader("Access-Control-Allow-Origin", "*");
        RespBean respBean = RespBean.ok("登录成功!", HrUtils.getCurrentHr());
        ObjectMapper objectMapper=new ObjectMapper();
        PrintWriter out=httpServletResponse.getWriter();
        out.write(objectMapper.writeValueAsString(respBean));
        out.flush();
        out.close();
    }
}
