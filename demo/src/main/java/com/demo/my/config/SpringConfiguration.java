package com.demo.my.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

// 标志该类是Spring的核心配置类
@Configuration
// context:component-scan base-package="com.demo.my"
@ComponentScan("com.demo.my")
// <context:property-placeholder location="classpath:jdbc.properties"/>
//@PropertySource("classpath:jdbc.properties")
// <import resource=""/>
@Import({DataSourceConfiguration.class})
public class SpringConfiguration {


}