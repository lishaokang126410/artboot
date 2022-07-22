package com.art.website.application;

import com.art.website.config.CacheConfig;
import com.art.website.config.SsmConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.annotation.Import;


/**
 * @Description:
 * @Author: Li shaoKang
 * @CreateDate: 2022/07/20 21:18
 * @Version: 1.0
 **/
@SpringBootApplication
@Import({SsmConfig.class})
public class SpringbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootApplication.class,args);
    }
}
