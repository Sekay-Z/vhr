package com.shukai.vhrserver.config;

import com.shukai.vhrserver.bean.Menu;
import com.shukai.vhrserver.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;

import java.util.Collection;
import java.util.List;
@Component
public class CustomMetadataSource implements FilterInvocationSecurityMetadataSource {
    @Autowired
    private MenuService menuService;
    AntPathMatcher antPathMatcher=new AntPathMatcher();
    @Override
    public Collection<ConfigAttribute> getAttributes(Object o) throws IllegalArgumentException {
        String requestUrl = ((FilterInvocation) o).getRequestUrl();
        List<Menu> allMenu = menuService.getAllMenu();
        for(Menu menu:allMenu){
            if(antPathMatcher.match(menu.getUrl(),requestUrl)&&menu.getRoles().size()>0){
                int size = menu.getRoles().size();
                String[] names=new String[size];
                for(int i=0;i<size;i++){
                    names[i]=menu.getRoles().get(i).getName();
                }
                return SecurityConfig.createList(names);
            }
        }
        return SecurityConfig.createList("ROLE_LOGIN");
    }//返回要访问的url所需权限

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return FilterInvocation.class.isAssignableFrom(aClass);
    }
}
