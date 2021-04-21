package com.dbappsecurity.demo;

import com.dbappsecurity.starter.security.authentication.mobile.MobileAuthenticationSecurityConfigurer;
import com.dbappsecurity.starter.security.authentication.mobile.MobileLoginConfigurer;
import com.dbappsecurity.starter.security.authentication.mobile.MobileUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author ycj
 * @datetime 2021-4-14 23:09
 * @describe
 */
@Configuration
public class DBWebSecurityConfigurerAdapter extends WebSecurityConfigurerAdapter {
    @Autowired
    private MobileUserDetailsService mobileUserDetailsService;
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        //new MobileAuthenticationSecurityConfigurer();
        //http.apply(new MobileAuthenticationSecurityConfigurer());
        http.csrf().disable();

        //http.authorizeRequests().antMatchers("/**").permitAll();
       // http.apply(new MobileAuthenticationSecurityConfigurer(mobileUserDetailsService));
        http.authorizeRequests().anyRequest().authenticated();
    }
}
