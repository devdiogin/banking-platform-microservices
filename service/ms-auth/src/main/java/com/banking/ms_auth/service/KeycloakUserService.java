package com.banking.ms_auth.service;

import com.banking.ms_auth.amqp.event.CustomerCreatedEvent;
import com.banking.ms_auth.config.KeycloakConfig;
import com.banking.ms_auth.exception.UserNotCreatedException;
import com.banking.ms_auth.exception.UserNotFoundException;
import jakarta.ws.rs.core.Response;
import lombok.RequiredArgsConstructor;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.representations.idm.CredentialRepresentation;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class KeycloakUserService {

    private final Keycloak keycloak;

    @Value("${keycloak.realm}")
    private String realm;

    public void createUser(CustomerCreatedEvent event) {
        String id = event.id().toString();

        var user = new UserRepresentation();
        user.setUsername(id);
        user.setEmail(event.email());
        user.setFirstName(event.name());

        user.setEnabled(false);
        user.setEmailVerified(false);

        try (Response response = keycloak
                .realm(realm)
                .users()
                .create(user)) {

            if (response.getStatus() != Response.Status.CREATED.getStatusCode()) {
                throw new UserNotCreatedException("Erro ao criar usuário no Keycloak. Status: " + response.getStatus());
            }
        }
    }

    public void enableUser(String username) {

        var users = keycloak
                .realm(realm)
                .users()
                .searchByUsername(username, true);

        if (users == null || users.isEmpty()) {
            throw new UserNotFoundException("Usuário não encontrado");
        }

        UserRepresentation user = users.getFirst();

        user.setEnabled(true);

        var userResource = keycloak
                .realm(realm)
                .users()
                .get(user.getId());
        userResource.update(user);
        userResource.executeActionsEmail(List.of("VERIFY_EMAIL", "UPDATE_PASSWORD"));
    }
}
