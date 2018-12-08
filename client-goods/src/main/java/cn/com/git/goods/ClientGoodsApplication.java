package cn.com.git.goods;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


//通过注解@EnableEurekaClient 表明自己是一个eurekaclient. 低版本用的是 @EnableDiscoveryClient 注解
@EnableEurekaClient
@SpringBootApplication
public class ClientGoodsApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClientGoodsApplication.class, args);
    }
}
