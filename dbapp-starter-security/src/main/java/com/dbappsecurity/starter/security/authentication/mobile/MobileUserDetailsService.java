package com.dbappsecurity.starter.security.authentication.mobile;

import com.dbappsecurity.starter.security.authentication.core.MobileUserDetails;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * @author ycj
 * @datetime 2021-4-14 21:42
 * @describe 短信登录时加载用户的服务类
 */
public interface MobileUserDetailsService {

    /**
     * 根据手机号加载用户
     * @param mobile 手机号
     * @return 用户信息
     * @throws UsernameNotFoundException 用户不存在
     */
    MobileUserDetails loadUserByMobile(String mobile) throws UsernameNotFoundException;

}
