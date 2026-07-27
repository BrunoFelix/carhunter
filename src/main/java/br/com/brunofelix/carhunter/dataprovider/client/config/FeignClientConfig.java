package br.com.brunofelix.carhunter.dataprovider.client.config;

import feign.Util;
import feign.codec.Decoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tools.jackson.databind.JavaType;
import tools.jackson.databind.ObjectMapper;
import tools.jackson.databind.type.TypeFactory;

@Configuration
public class FeignClientConfig {

    @Bean
    public Decoder feignDecoder() {
        return (response, type) -> {
            String bodyStr = Util.toString(response.body().asReader(Util.UTF_8));
            int start = bodyStr.indexOf('{');
            if (start == -1) {
                start = bodyStr.indexOf('[');
            }
            if (start > 0) {
                bodyStr = bodyStr.substring(start);
            }
            JavaType javaType = TypeFactory.createDefaultInstance().constructType(type);
            return new ObjectMapper().readValue(bodyStr, javaType);
        };
    }
}
