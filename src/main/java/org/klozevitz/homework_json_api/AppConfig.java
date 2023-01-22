package org.klozevitz.homework_json_api;

import org.klozevitz.homework_json_api.logic.ISolution;
import org.klozevitz.homework_json_api.controllers.LinearOperatorService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    ISolution solution() {
        return new LinearOperatorService();
    }
}
