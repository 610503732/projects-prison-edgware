package cn.com.git.hystrix.dashboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
//开启断路器监控
@EnableHystrixDashboard
@SpringBootApplication
public class ServerHystrixDashboardApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServerHystrixDashboardApplication.class, args);
    }
}
