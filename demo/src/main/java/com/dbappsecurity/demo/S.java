package com.dbappsecurity.demo;

import com.dbappsecurity.starter.security.authentication.core.MobileUserDetails;
import com.dbappsecurity.starter.security.authentication.mobile.MobileUserDetailsService;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @author ycj
 * @datetime 2021-4-15 10:20
 * @describe
 */
@Service
public class S implements MobileUserDetailsService {

    @Override
    public MobileUserDetails loadUserByMobile(String mobile) throws UsernameNotFoundException {
        return () -> "123";
    }

}
