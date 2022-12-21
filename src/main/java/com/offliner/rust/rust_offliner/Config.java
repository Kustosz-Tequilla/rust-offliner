package com.offliner.rust.rust_offliner;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

//    @Value("${bm.apiKey}")
//    private String bmApiKey;

    @Bean
    @Qualifier("Battlemetrics")
    public WebClient bmWebClient() {
        return WebClient.builder()
                .baseUrl("https://api.battlemetrics.com")
                .defaultHeader("Authorization", "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ0b2tlbiI6ImM1NGEzYjE5NjI1YTVkOWUiLCJpYXQiOjE2NjgxNjc4NjEsIm5iZiI6MTY2ODE2Nzg2MSwiaXNzIjoiaHR0cHM6Ly93d3cuYmF0dGxlbWV0cmljcy5jb20iLCJzdWIiOiJ1cm46dXNlcjo2Mjc0NzAifQ.aoPomPHe_scpBQ6yVmgObs1DRuWzXE0PiVuUFhks4bw")
                .build();
    }

    @Bean
    @Qualifier("RustMaps")
    public WebClient rmWebClient() {
        System.out.println("XDDD");
        return WebClient.builder()
                .baseUrl("https://rustmaps.com/api/v2/maps/")
                .defaultHeader("x-api-key", "eac67d8a-a2d0-4d1f-bd3d-29a40be14799")
                .build();
    }


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
