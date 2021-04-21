package com.dbappsecurity.teststarter;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanNameGenerator;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.context.properties.ConfigurationPropertiesBindingPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.annotation.MergedAnnotation;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author ycj
 * @datetime 2021-4-12 9:03
 * @describe
 */
public class AutoConfig implements ImportBeanDefinitionRegistrar {

    private static final String BEAN_NAME = AutoConfig.class.getName();

    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        MergedAnnotation<EnableTest> enableTestMergedAnnotation = importingClassMetadata.getAnnotations().get(EnableTest.class);
        if (!registry.containsBeanDefinition(BEAN_NAME)) {
            String v = enableTestMergedAnnotation.getString("value");
            System.out.println(v);
            BeanDefinition definition = BeanDefinitionBuilder.genericBeanDefinition(AutoConfig.class, AutoConfig::new).getBeanDefinition();
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
