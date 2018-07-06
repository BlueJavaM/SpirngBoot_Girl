package com.springboot.beans;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 *@Author: XieLiang
 *@Date : 2018/7/2
 *@Comment :
 */
@Component
@ConfigurationProperties(prefix = "girl")  //获取前缀为girl的配置
public class GirlProperties {

    private String girlName;
    private int age;
    private String sex;

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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "GirlProperties{" +
                "girlName='" + girlName + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                '}';
    }
}
