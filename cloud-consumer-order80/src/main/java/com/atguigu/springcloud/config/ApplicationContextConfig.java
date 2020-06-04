package com.atguigu.springcloud.config;

        import org.springframework.cloud.client.loadbalancer.LoadBalanced;
        import org.springframework.context.annotation.Bean;
        import org.springframework.context.annotation.Configuration;
        import org.springframework.web.client.RestTemplate;

/**
 * @author: ChaW
 * @date: 2020/5/21
 * @time: 20:27
 * @description: No Description
 * @version: 1.0
 */
@Configuration
public class ApplicationContextConfig {

    @Bean
//    @LoadBalanced
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
