package com.pie.nacos.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * ClassName DemoController
 * Description
 * Date 2021/8/6
 * Author wangxiyue.xy@163.com
 */
@RestController
@RequestMapping("/demo")
public class DemoController {

    @Autowired
    DemoService service;

    @RequestMapping("/f")
    public List find(){
        return service.findall();
    }
}
