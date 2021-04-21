package com.dbappsecurity.starter.security.authentication.config;

import com.dbappsecurity.starter.security.authentication.B;
import com.dbappsecurity.starter.security.authentication.MobileWebSecurityConfigurer;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author ycj
 * @datetime 2021-4-15 10:41
 * @describe
 */
public class C implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        return new String[]{B.class.getName(), MobileAutoConfigurer.class.getName(), MobileWebSecurityConfigurer.class.getName()};
    }
}
