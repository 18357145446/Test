package com.dbappsecurity.demo;

import com.dbappsecurity.starter.security.EnableDbappSecurity;
import com.dbappsecurity.teststarter.EnableTest;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author ycj
 * @datetime 2021-4-12 0:02
 * @describe
 */
@EnableDbappSecurity(mobile = true, code = false)
@EnableTest(value = "测试")
@SpringBootApplication
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
