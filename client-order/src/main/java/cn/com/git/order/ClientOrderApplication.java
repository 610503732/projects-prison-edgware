package cn.com.git.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

//开启断路器，用于监控识别
//访问 http://localhost:7002/hystrix.stream 查看断路器状态
@EnableHystrix
//通过注解@EnableEurekaClient 表明自己是一个eurekaclient. 低版本用的是 @EnableDiscoveryClient 注解
@EnableEurekaClient
//支持 feign 的注解
@EnableFeignClients
@SpringBootApplication
public class ClientOrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClientOrderApplication.class, args);
    }
}
