package net.maku;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
/**
 * @author: minder
 * @createTime: 2025/06/09 16:27
 * @description:
 **/
@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class ScreenApplication {
    public static void main(String[] args) {
        SpringApplication.run(ScreenApplication.class, args);
    }
}
