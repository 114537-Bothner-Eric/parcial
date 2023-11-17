package ar.edu.utn.frc.tup.lciii.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;


/** Configuration class for creating a RestTemplate bean. */
@Configuration
public class RestClientConfig {
    /**
     * Create and configure a RestTemplate bean.
     *
     * @return an instance of config RestTemplate.
     */
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    /* private static  final int TIME_OUT = 1000;
    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder){
        return builder
                .setConnectTimeout(Duration.ofMillis(TIME_OUT))
                .setReadTimeout(Duration.ofMillis(TIME_OUT))
                .build();
    } */
}



