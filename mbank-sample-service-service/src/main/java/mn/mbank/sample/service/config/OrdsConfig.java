package mn.mbank.sample.service.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
@ConfigurationProperties(prefix = "serviceconfig")
@Data
public class OrdsConfig {

    private Ords ords;

    @Data
    public static class Ords{
        private String url1;
        private String url2;
        private String url3;
    }

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

}
