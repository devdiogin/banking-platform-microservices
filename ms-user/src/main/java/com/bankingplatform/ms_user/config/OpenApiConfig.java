package com.bankingplatform.ms_user.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.stereotype.Component;

@Component
public class OpenApiConfig {

    public OpenAPI openAPI() {
        return new OpenAPI().info(
                new Info().title("ms-User")
                        .description("Documentação do microsservice de usuário")
                        .contact(new Contact()
                                .name("dev-diogin")
                                .email("dev.diogelucas@gmail.com")
                                .url("https://www.linkedin.com/in/dev-cassimiro/"))
        );
    }
}
