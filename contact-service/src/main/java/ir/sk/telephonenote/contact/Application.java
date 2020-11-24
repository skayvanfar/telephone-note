package ir.sk.telephonenote.contact;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Collections;
import java.util.List;

/**
 * Created by sad.kayvanfar on 11/18/2020.
 */
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public RestTemplate getCustomRestTemplate(){
        return new RestTemplate();
    }

    @Bean
    public WebClient getWebClient(){
        return WebClient.create("https://api.github.com/");
    }
}
