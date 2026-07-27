package br.com.brunofelix.carhunter.dataprovider.client.config;

import feign.RequestInterceptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignClientVia1Config {

    private static final String AUTHORIZATION = "Authorization";

    @Value("${via1.client.token}")
    private String via1AuthorizationToken;

    @Bean
    public RequestInterceptor requestVia1Interceptor() {
        return requestTemplate -> requestTemplate.header(AUTHORIZATION, via1AuthorizationToken);
    }
}
