package br.com.vinicius.finance_control_api.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI().info(new Info()
                .title("Finance Control API")
                .description("API Rest of finance control")
                .contact(new Contact()
                        .name("Time Backend")
                        .email("viniciusdamsil@gmail.com")));
    }
}
