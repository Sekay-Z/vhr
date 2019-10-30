package com.shukai.vhrserver.config;

import com.shukai.vhrserver.service.HrServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.ObjectPostProcessor;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    HrServiceImpl hrService;
    @Autowired
    CustomMetadataSource customMetadataSource;
    @Autowired
    UrlAccessDecisionManager urlAccessDecisionManager;
    @Autowired
    LoginSuccessHandler loginSuccessHandler;
    @Autowired
    LoginFailureHandler loginFailureHandler;
    @Autowired
    LogoutSuccessHandler logoutSuccessHandler;
    @Autowired
    AuthenticationAccessDeniedHandler accessDeniedHandler;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(hrService).passwordEncoder(new BCryptPasswordEncoder());
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/index.html", "/static/**", "/login_p", "/favicon.ico");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin().loginPage("/login_p").loginProcessingUrl("/login")
            .usernameParameter("username").passwordParameter("password")
            .successHandler(loginSuccessHandler).failureHandler(loginFailureHandler)
            .permitAll()
            .and()
            .logout().logoutUrl("/logout").logoutSuccessHandler(logoutSuccessHandler).permitAll()
            .and()
            .authorizeRequests().withObjectPostProcessor(new ObjectPostProcessor<FilterSecurityInterceptor>() {
            @Override
            public <O extends FilterSecurityInterceptor> O postProcess(O o) {
                o.setSecurityMetadataSource(customMetadataSource);
                o.setAccessDecisionManager(urlAccessDecisionManager);
                return o;
            }
            })
            .and()
            .cors()
            .and()
            .csrf().disable()
            .exceptionHandling().accessDeniedHandler(accessDeniedHandler)
            .and()
            .anonymous().disable();
    }
}
