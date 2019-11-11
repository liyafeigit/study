package com.sclbxx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author lyf
 * @Date 16:57 2018/7/17
 */
@RestController
public class HelloControler {

    @Autowired
    HelloService helloService;

    @GetMapping(value = "/hi")
    public String hi(@RequestParam(value = "name",defaultValue = "im") String name) {
        return helloService.hiService( name );
    }

}
