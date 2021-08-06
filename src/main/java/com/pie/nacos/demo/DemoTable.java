package com.pie.nacos.demo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import static com.sun.xml.internal.ws.policy.sourcemodel.wspolicy.XmlToken.Name;

/**
 * ClassName DemoTable
 * Description
 * Date 2021/8/6
 * Author wangxiyue.xy@163.com
 */
@Entity
@Table(name = "table_demo")
public class DemoTable {


    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;
    @Column(name= "value")
    private String value;


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
