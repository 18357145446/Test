package com.dbappsecurity.starter.security;

import com.dbappsecurity.starter.security.authentication.A;
import com.dbappsecurity.starter.security.authentication.B;
import com.dbappsecurity.starter.security.authentication.MobileWebSecurityConfigurer;
import com.dbappsecurity.starter.security.authentication.config.C;
import org.springframework.context.annotation.Import;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import java.lang.annotation.*;

/**
 * @author ycj
 * @datetime 2021-4-14 23:05
 * @describe
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import({C.class, A.class})
public @interface EnableDbappSecurity {
    boolean mobile();

    boolean code();
}
