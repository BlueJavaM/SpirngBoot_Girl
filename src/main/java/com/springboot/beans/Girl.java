package com.springboot.beans;

import org.springframework.data.annotation.Id;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.validation.constraints.Min;

/*
 *@Author: XieLiang
 *@Date : 2018/7/2
 *@Comment :
 */

@Entity
public class Girl {

    @javax.persistence.Id
    @GeneratedValue
    private Integer id;
    private String girlName;
    @Min(value = 18,message = "未成年少女禁止入内")
    private int age;
    private String cupSize;

    public Girl() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGirlName() {
        return girlName;
    }

    public void setGirlName(String girlName) {
        this.girlName = girlName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCupSize() {
        return cupSize;
    }

    public void setCupSize(String cupSize) {
        this.cupSize = cupSize;
    }
}
