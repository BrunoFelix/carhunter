package br.com.brunofelix.carhunter.dataprovider.client.config;

import feign.RequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.UUID;

@Configuration
public class FeignClientOlxConfig {

    private static final String USER_AGENT = "User-Agent";
    private static final String ACCEPT = "Accept";
    private static final String POSTMAN_TOKEN = "Postman-Token";
    private static final String HOST = "Host";
    private static final String ACCEPT_ENCODING = "Accept-Encoding";
    private static final String CONNECTION = "Connection";
    private static final String COOKIE = "Cookie";

    @Bean
    public RequestInterceptor requestOlxInterceptor() {
        return requestTemplate -> requestTemplate
                .header(USER_AGENT, "PostmanRuntime/7.37.3")
                .header(ACCEPT, "*/*")
                .header(POSTMAN_TOKEN, UUID.randomUUID().toString())
                .header(HOST, "www.olx.com.br")
                .header(ACCEPT_ENCODING, "gzip, deflate, br")
                .header(CONNECTION, "keep-alive")
                .header(COOKIE, "r_id=42ff87e4-039f-410a-a46f-0676db1b753f");
    }
}
