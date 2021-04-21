package com.dbappsecurity.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ycj
 * @datetime 2021-4-15 10:25
 * @describe
 */
@RestController
public class Contor {

    @RequestMapping("/hh")
    public String aa() {
        return "gsgds";
    }
}
