package com.dbappsecurity.starter.security.authorization;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import java.util.List;

/**
 * @author ycj
 * @datetime 2021-4-15 11:24
 * @describe
 */
public class DBAppWebSecurityAdapter extends WebSecurityConfigurerAdapter {

    @Autowired(required = false)
    private List<AuthorizeConfigProvider> authorizeConfigProviders;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        super.configure(http);

        if (authorizeConfigProviders != null) {
            for (AuthorizeConfigProvider provider : authorizeConfigProviders) {
                provider.configure(http);
            }
        }
    }
}
