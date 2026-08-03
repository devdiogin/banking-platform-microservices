package com.banking.ms_customer.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Address {

    @Column(length = 150, nullable = false)
    private String street;

    @Column(length = 20, nullable = false)
    private String number;

    @Column(length = 100, nullable = false)
    private String neighborhood;

    @Column(length = 100, nullable = false)
    private String city;

    @Column(length = 9, nullable = false)
    private String zipCode;

    @Column(length = 2, nullable = false)
    private String state;

    @Column(length = 100)
    private String complement;
}
