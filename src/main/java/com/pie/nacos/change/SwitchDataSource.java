package com.pie.nacos.change;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.fastjson.JSON;
import com.alibaba.nacos.api.NacosFactory;
import com.alibaba.nacos.api.annotation.NacosInjected;
import com.alibaba.nacos.api.config.ConfigService;
import com.alibaba.nacos.api.exception.NacosException;
import com.pie.nacos.nacosconfig.NacosConfigConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 * ClassName SwitchDataSource
 * Description
 * Date 2021/7/23
 * Author wangxiyue.xy@163.com
 */
@Component
@RefreshScope
@DependsOn
public class SwitchDataSource {

    private Logger log = LoggerFactory.getLogger(SwitchDataSource.class);

    @Autowired(required = false)
    private DruidDataSource dataSource;

//    @Value("${db.url}")
    private String url;
//    @Value("${db.username}")
    private String username;
//    @Value("${db.password}")
    private String password;


    /***
     * province.db=beijing###jdbc:mysql://127.0.0.1:3306/demo?char_set=utf8#root#root,
     * tianjin###jdbc:mysql://127.0.0.1:3306/demo2?char_set=utf8#root#root
     */
    @Value("${province.db}")
    private String[]  db;


    public void switchSource(){
        switchSource(url,username,password);
    }

    private Map<String,String> checkConfig(String[] content){
        HashMap<String,String> map = new HashMap<>();
        String[] tmp =null;
        for (String s : content) {
            tmp = s.split("###");
            map.put(tmp[0],tmp[1]);
        }
        return map;
    }


    public boolean selectDataSource(String where){
          Map<String,String> map = checkConfig(db);

          String dataSource = map.get(where.toLowerCase());
          if(dataSource!=null && dataSource.length()>0){
              String[] obj = dataSource.split("#");
              switchSource(obj[0],obj[1],obj[2]);
              return true;
          }
          return false;
    }

    public void switchSource(String url , String username ,String password){
        log.debug("url={} , username = {} , password = {}",url,username,password);
        try {
            dataSource.close();
            dataSource.resetStat();
            dataSource.restart();
            dataSource.setUrl(url);
            dataSource.setUsername(username);
            dataSource.setPassword(password);
            dataSource.init();
            log.debug("change data source from {}",url);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

}
