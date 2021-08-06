package com.pie.nacos.change;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName SwitchController
 * Description
 * Date 2021/8/6
 * Author wangxiyue.xy@163.com
 */
@RestController
@RequestMapping("/change")
public class SwitchController {

    @Autowired
    SwitchDataSource switchDataSource;

    @RequestMapping("/selectDataSource")
    public boolean changeDataSource(String province){
        return switchDataSource.selectDataSource(province);
    }

    public void init(){
        switchDataSource.selectDataSource("beijing");
    }
}
