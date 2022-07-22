package com.art.website.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan("com.oracle.springboot")
@EnableTransactionManagement
@MapperScan("com.oracle.springboot.mapper")
public class SsmConfig {
}
