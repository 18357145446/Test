package com.dbappsecurity.starter.security.authorization;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;

/**
 * @author ycj
 * @datetime 2021-4-15 11:23
 * @describe
 */
public interface AuthorizeConfigProvider {

    void configure(HttpSecurity http);

}
