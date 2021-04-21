package com.dbappsecurity.starter.security.authentication.core;

import org.springframework.security.core.userdetails.UserDetails;

/**
 * @author ycj
 * @datetime 2021-4-15 17:14
 * @describe
 */
public interface MobileUserDetails extends UserDetails {

    /**
     * 获取手机号
     * @return 手机号
     */
    String getMobile();

}
