package com.dbappsecurity.teststarter;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @author ycj
 * @datetime 2021-4-11 23:58
 * @describe
 */
//@ConditionalOnProperty(prefix = "test", value = "enable", havingValue = "true")
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(Config.class)
public @interface EnableTest {

    String value();
}
