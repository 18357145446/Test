package com.dbappsecurity.starter.security.authentication;

import com.dbappsecurity.starter.security.EnableDbappSecurity;
import com.dbappsecurity.starter.security.authentication.config.MobileAutoConfigurer;
import com.dbappsecurity.starter.security.authentication.mobile.MobileAuthenticationProvider;
import com.dbappsecurity.starter.security.authentication.mobile.MobileAuthenticationSecurityConfigurer;
import com.dbappsecurity.starter.security.authentication.mobile.MobileLoginConfigurer;
import com.dbappsecurity.starter.security.authentication.mobile.MobileUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.annotation.MergedAnnotation;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.config.annotation.SecurityBuilder;
import org.springframework.security.config.annotation.web.HttpSecurityBuilder;
import org.springframework.security.config.annotation.web.WebSecurityConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractAuthenticationFilterConfigurer;
import org.springframework.security.config.annotation.web.configurers.FormLoginConfigurer;
import org.springframework.security.web.util.matcher.RequestMatcher;

/**
 * @author ycj
 * @datetime 2021-4-14 22:45
 * @describe
 */
public class MobileWebSecurityConfigurer implements ImportBeanDefinitionRegistrar {

    private static final String BEAN_NAME = MobileAutoConfigurer.class.getName();

    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        MergedAnnotation<EnableDbappSecurity> annotation = importingClassMetadata.getAnnotations().get(EnableDbappSecurity.class);
        if (!registry.containsBeanDefinition(BEAN_NAME)) {
            boolean mobile = annotation.getBoolean("mobile");
            boolean code = annotation.getBoolean("code");
            System.out.println(mobile);
            System.out.println(code);
            BeanDefinition definition = BeanDefinitionBuilder.genericBeanDefinition(MobileAutoConfigurer.class, MobileAutoConfigurer::new).getBeanDefinition();
            definition.setRole(2);
            registry.registerBeanDefinition(BEAN_NAME, definition);
        }
    }

    @Bean
    public CommandLineRunner commandLineRunner() {
        return args -> {
            System.out.println("测试starter启动啦");
        };
    }
}
