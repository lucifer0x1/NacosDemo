package com.pie.nacos.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * ClassName DemoService
 * Description
 * Date 2021/8/6
 * Author wangxiyue.xy@163.com
 */
@Service
public class DemoService {

    @Autowired
    DemoJpaDao dao;

    public List findall(){
        return dao.findAll();
    }
}
