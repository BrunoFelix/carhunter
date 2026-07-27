package br.com.brunofelix.carhunter.dataprovider.client.config;

import feign.RequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignClientWebMotorsConfig {

    private static final String USER_AGENT = "User-Agent";

    @Bean
    public RequestInterceptor requestWebMotorsInterceptor() {
        return requestTemplate -> requestTemplate
                .header(USER_AGENT, "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/122.0.0.0 Safari/537.36");
    }
}
