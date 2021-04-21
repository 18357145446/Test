package com.dbappsecurity.starter.security.authentication.mobile;

import com.dbappsecurity.starter.security.authentication.core.MobileUserDetails;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.util.Assert;

/**
 * @author ycj
 * @datetime 2021-4-14 21:45
 * @describe 短信登录的身份验证提供者
 */
public class MobileAuthenticationProvider implements AuthenticationProvider {

    private MobileUserDetailsService userDetailsService;

    private void additionalAuthenticationChecks(MobileUserDetails userDetails, MobileAuthenticationToken authentication)
            throws AuthenticationException {

    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        MobileAuthenticationToken authenticationToken = (MobileAuthenticationToken) authentication;

        MobileUserDetails user;
        String mobile = (String) authenticationToken.getPrincipal();
        try {
            Assert.hasText(mobile, "Mobile parameter must not be empty or null");
            user = userDetailsService.loadUserByMobile((String) authenticationToken.getPrincipal());
        } catch (IllegalArgumentException e) {
            throw new UsernameNotFoundException(e.getMessage());
        }

        if (user == null) {
            throw new UsernameNotFoundException("无法获取用户信息");
        }

        MobileAuthenticationToken token = new MobileAuthenticationToken(user, user.getAuthorities());
        token.setDetails(authentication.getDetails());

        return token;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return MobileAuthenticationToken.class.isAssignableFrom(aClass);
    }

    public MobileUserDetailsService getUserDetailsService() {
        return userDetailsService;
    }

    public void setUserDetailsService(MobileUserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

}
