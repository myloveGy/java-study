package com.demo.my.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

// 标志该类是Spring的核心配置类
@Configuration
// context:component-scan base-package="com.demo.my"
@ComponentScan("com.demo.my")
@EnableAspectJAutoProxy
@EnableTransactionManagement
// <context:property-placeholder location="classpath:jdbc.properties"/>
//@PropertySource("classpath:jdbc.properties")
// <import resource=""/>
@Import({
        DataSourceConfiguration.class,
        RedisConfiguration.class,
        RedisConnectionConfiguration.class,
        RedisTemplateConfiguration.class,
        JdbcTemplateConfiguration.class,
})
public class SpringConfiguration {


}
