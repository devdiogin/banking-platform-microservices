package com.banking.ms_customer.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Banking Platform - Customer Service")
                        .description("Microsserviço responsável pelo gerenciamento de clientes da plataforma bancária.")
                        .version("v1")
                        .contact(new Contact()
                                .name("Diogenes Cassimiro")
                                .email("diogenes.cassimiro.dev@gmail.com")
                                .url("https://www.linkedin.com/in/dev-cassimiro")
                        )
                );
    }
}
