package com.sclbxx;

import org.springframework.stereotype.Component;

/**
 * @Author lyf
 * @Date 10:49 2018/7/18
 */
@Component
public class SchedualServiceHiHystric implements SchedualServiceHi {

    @Override
    public String sayHiFromClientOne(String name) {
        return "sorry "+name;
    }
}
