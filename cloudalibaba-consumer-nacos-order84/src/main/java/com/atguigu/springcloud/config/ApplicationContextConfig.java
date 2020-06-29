package com.atguigu.springcloud.config;

        import org.springframework.cloud.client.loadbalancer.LoadBalanced;
        import org.springframework.context.annotation.Bean;
        import org.springframework.context.annotation.Configuration;
        import org.springframework.web.bind.annotation.RestController;
        import org.springframework.web.client.RestTemplate;

/**
 * @Author: Ryan
 * @Date: 2020/6/20 18:33
 * @Version: 1.0
 * @Description:
 */
@Configuration
public class ApplicationContextConfig {

    @Bean
    @LoadBalanced
    public RestTemplate getTemplate() {
        return new RestTemplate();
    }
}
