package com.pie.nacos.controller;

import com.pie.nacos.change.SwitchDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName IndexController
 * Description
 * Date 2021/7/16
 * Author wangxiyue.xy@163.com
 */
@RestController
@RequestMapping("/")
//@RefreshScope
public class IndexController {

//    @Value(value = "${service.a}")
    private String abc ;

    @Autowired
    SwitchDataSource switchDataSource;



    @RequestMapping("/a")
    public String findA(){
        return abc;
    }

    @RequestMapping("/b")
    public String findB( String a){
        return a;
    }

}
