package top.cry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author: orange
 * @projectName: cry-cloud
 * @description:
 */
@SpringBootApplication
@EnableDiscoveryClient
public class IoTApplication {

    public static void main(String[] args) {
        SpringApplication.run(IoTApplication.class, args);
    }

}