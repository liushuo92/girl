package com.lawrence.propertites;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by liush
 * 2018/8/20   15:37
 */
@Component
@ConfigurationProperties(prefix = "girl")
public class GirlPropertites {

    private String cupsize;

    private Integer age;

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getCupsize() {

        return cupsize;
    }

    public void setCupsize(String cupsize) {
        this.cupsize = cupsize;
    }
}
