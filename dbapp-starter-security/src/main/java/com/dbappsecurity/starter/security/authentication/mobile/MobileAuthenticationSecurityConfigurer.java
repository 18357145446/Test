package com.dbappsecurity.starter.security.authentication.mobile;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.util.Assert;

/**
 * @author 姚铖杰
 * @datetime 2021-4-14 21:49
 * @describe 短信登录配置类
 **/
public class MobileAuthenticationSecurityConfigurer extends
        SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity> {

    /*@Autowired
    private AuthenticationFailureHandler failureHandler;

    @Autowired
    private AuthenticationSuccessHandler successHandler;

    @Autowired
    private MobileUserDetailsService smsUserDetailsService;

    @Autowired
    private SecurityProperties securityProperties;*/


    private MobileUserDetailsService mobileUserDetailsService;

    public MobileAuthenticationSecurityConfigurer(MobileUserDetailsService mobileUserDetailsService) {
        this.mobileUserDetailsService = mobileUserDetailsService;
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        // 配置身份验证提供者
        MobileAuthenticationProvider provider = new MobileAuthenticationProvider();
        provider.setUserDetailsService(mobileUserDetailsService);

        http
                .authenticationProvider(provider)
                .addFilterAfter(filter(http.getSharedObject(AuthenticationManager.class)),
                        UsernamePasswordAuthenticationFilter.class);

    }

    /**
     * 配置短信登录拦截器
     * @param authenticationManager 认证管理器
     * @return 短信登录拦截器
     */
    protected MobileAuthenticationFilter filter(AuthenticationManager authenticationManager) {
        MobileAuthenticationFilter filter = new MobileAuthenticationFilter(authenticationManager);
        //filter.setAuthenticationManager(authenticationManager);
        //filter.setAuthenticationSuccessHandler(successHandler);
        //filter.setAuthenticationFailureHandler(failureHandler);
        //filter.mobileParameter(securityProperties.getMobileParameter());
        //filter.loginProcessesUrl(securityProperties.getMobileLoginProcessingUrl());
        return filter;
    }

}
