package com.dbappsecurity.teststarter;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.AdviceMode;
import org.springframework.context.annotation.AdviceModeImportSelector;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author ycj
 * @datetime 2021-4-11 23:54
 * @describe
 */
public class Config implements ImportSelector {

    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        return new String []{AutoConfig.class.getName()};
    }
}
