package com.pazz.springbootweb.configuration;

import com.pazz.springbootweb.bean.TestBean;
import com.pazz.springbootweb.properties.TestProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: 彭坚
 * @create: 2018/8/24 16:17
 * @description:
 */
@Configuration
@EnableConfigurationProperties(TestProperties.class)
@AutoConfigureAfter(WebConfiguration.class)
public class TestConfiguration {

    @Autowired
    private TestProperties testProperties;

    public TestConfiguration(){
        System.out.println("TestConfiguration@initial" + testProperties);
    }

    @Bean
    @ConditionalOnMissingBean
    public TestBean testBean(){
        TestBean testBean = new TestBean();
        testBean.setName(testProperties.getName());
        return testBean;
    }

}
