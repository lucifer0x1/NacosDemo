package com.pie.nacos.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

/**
 * ClassName DemoJpaDao
 * Description
 * Date 2021/8/6
 * Author wangxiyue.xy@163.com
 */
@Component
public interface DemoJpaDao extends JpaRepository<DemoTable,Long> {
}
