package com.bankingplatform.ms_user.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("MS User API")
                        .version("1.0.0")
                        .description("API responsável pelo gerenciamento de usuários da Banking Platform.")
                        .contact(new Contact()
                                .name("Diogenes Cassimiro")
                                .email("dev.diogelucas@gmail.com")
                                .url("https://www.linkedin.com/in/dev-cassimiro/")));
    }
}
