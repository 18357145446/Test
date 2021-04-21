package com.dbappsecurity.starter.security.authentication.mobile;

import org.springframework.context.ApplicationContext;
import org.springframework.security.config.annotation.web.HttpSecurityBuilder;
import org.springframework.security.config.annotation.web.configurers.AbstractAuthenticationFilterConfigurer;
import org.springframework.security.config.annotation.web.configurers.FormLoginConfigurer;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.authentication.ForwardAuthenticationFailureHandler;
import org.springframework.security.web.authentication.ForwardAuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.ui.DefaultLoginPageGeneratingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;

/**
 * @author ycj
 * @datetime 2021-4-14 22:25
 * @describe {@link org.springframework.security.config.annotation.web.configurers.FormLoginConfigurer 参考}
 */
public class MobileLoginConfigurer<H extends HttpSecurityBuilder<H>> extends
        AbstractAuthenticationFilterConfigurer<H, MobileLoginConfigurer<H>, MobileAuthenticationFilter> {

    public MobileLoginConfigurer() {
        super(new MobileAuthenticationFilter(), null);
        mobileParameter("mobile");
    }

    @Override
    protected MobileLoginConfigurer<H> loginPage(String loginPage) {
        return super.loginPage(loginPage);
    }

    @Override
    protected RequestMatcher createLoginProcessingUrlMatcher(String loginProcessingUrl) {
        return new AntPathRequestMatcher(loginProcessingUrl, "POST");
    }

    /**
     * The HTTP parameter to look for the mobile when performing authentication. Default
     * is "username".
     * @param mobileParameter the HTTP parameter to look for the mobile when
     * performing authentication
     * @return the {@link FormLoginConfigurer} for additional customization
     */
    public MobileLoginConfigurer<H> mobileParameter(String mobileParameter) {
        getAuthenticationFilter().setMobileParameter(mobileParameter);
        return this;
    }

    /**
     * Forward Authentication Failure Handler
     * @param forwardUrl the target URL in case of failure
     * @return the {@link FormLoginConfigurer} for additional customization
     */
    public MobileLoginConfigurer<H> failureForwardUrl(String forwardUrl) {
        failureHandler(new ForwardAuthenticationFailureHandler(forwardUrl));
        return this;
    }

    /**
     * Forward Authentication Success Handler
     * @param forwardUrl the target URL in case of success
     * @return the {@link FormLoginConfigurer} for additional customization
     */
    public MobileLoginConfigurer<H> successForwardUrl(String forwardUrl) {
        successHandler(new ForwardAuthenticationSuccessHandler(forwardUrl));
        return this;
    }

    @Override
    public void init(H http) throws Exception {
        super.init(http);
        initProvider(http);
        initDefaultLoginFilter(http);
    }

    private void initProvider(H http) {
        ApplicationContext context = http.getSharedObject(ApplicationContext.class);
        // 配置身份验证提供者
        MobileAuthenticationProvider provider = new MobileAuthenticationProvider();
        provider.setUserDetailsService(context.getBean(MobileUserDetailsService.class));

        http
                .authenticationProvider(provider);
    }
    /**
     * If available, initializes the {@link DefaultLoginPageGeneratingFilter} shared
     * object.
     * @param http the {@link HttpSecurityBuilder} to use
     */
    private void initDefaultLoginFilter(H http) {
        http.addFilterBefore(this.getAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
        /*DefaultLoginPageGeneratingFilter loginPageGeneratingFilter = http
                .getSharedObject(DefaultLoginPageGeneratingFilter.class);
        if (loginPageGeneratingFilter != null && !isCustomLoginPage()) {
            loginPageGeneratingFilter.setFormLoginEnabled(true);
            loginPageGeneratingFilter.setUsernameParameter(getUsernameParameter());
            loginPageGeneratingFilter.setPasswordParameter(getPasswordParameter());
            loginPageGeneratingFilter.setLoginPageUrl(getLoginPage());
            loginPageGeneratingFilter.setFailureUrl(getFailureUrl());
            loginPageGeneratingFilter.setAuthenticationUrl(getLoginProcessingUrl());
        }*/
    }

    /**
     * Gets the HTTP parameter that is used to submit the mobile number.
     * @return the HTTP parameter that is used to submit the mobile number
     */
    private String getMobileParameter() {
        return getAuthenticationFilter().getMobileParameter();
    }

}
