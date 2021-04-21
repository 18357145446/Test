package com.dbappsecurity.starter.security.authentication;

import com.dbappsecurity.starter.security.authentication.mobile.MobileAuthenticationSecurityConfigurer;
import com.dbappsecurity.starter.security.authentication.mobile.MobileLoginConfigurer;
import com.dbappsecurity.starter.security.authentication.mobile.MobileUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * @author ycj
 * @datetime 2021-4-14 21:40
 * @describe
 */
@Order(1)
//@Configuration
public class B extends AbstractHttpConfigurer<B, HttpSecurity> {

    private MobileLoginConfigurer<HttpSecurity> mobileLoginConfigurer = new MobileLoginConfigurer<>();;

    @Override
    public void init(HttpSecurity http) throws Exception {
        // any method that adds another configurer
        // must be done in the init method
        super.init(http);
        http.csrf().disable();
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {

        ApplicationContext context = http.getSharedObject(ApplicationContext.class);

        // here we lookup from the ApplicationContext. You can also just create a new instance.
        /*MyFilter myFilter = context.getBean(MyFilter.class);
        myFilter.setFlag(flag);
        http.addFilterBefore(myFilter, UsernamePasswordAuthenticationFilter.class);*/
        http.apply(mobileLoginConfigurer);
    }

    public MobileLoginConfigurer<HttpSecurity> mobileLogin() {
        //this.mobileLoginConfigurer =  new MobileLoginConfigurer<>();
        return this.mobileLoginConfigurer;
    }

    public MobileLoginConfigurer<HttpSecurity> mobileParameter(String mobileParameter) {
        this.mobileLoginConfigurer.mobileParameter(mobileParameter);
        return this.mobileLoginConfigurer;
    }
}
