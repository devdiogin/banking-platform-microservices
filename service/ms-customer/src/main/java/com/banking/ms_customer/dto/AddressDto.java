package com.banking.ms_customer.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record AddressDto(
        @NotBlank(message = "Informe o logradouro.")
        String street,

        @NotBlank(message = "Informe o número.")
        String number,

        @NotBlank(message = "Infome o bairro.")
        String neighborhood,

        @NotBlank(message = "Informe a cidade.")
        String city,

        @NotBlank(message = "Informe o código postal.")
        @Pattern(regexp = "\\d{5}-?\\d{3}",
                message = "CEP deve estar no formato 12345-678 ou 12345678.")
        String zipCode,

        @NotBlank(message = "Informe a sigla do estado.")
        @Size(min = 2, max = 2, message = "A sigla do estado deve conter exatamente 2 caracteres.")
        String state,

        String complement
) {
}
