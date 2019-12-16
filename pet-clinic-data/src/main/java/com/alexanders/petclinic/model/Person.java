package com.alexanders.petclinic.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Person extends BaseEntity {

    private String firstName;
    private String lastName;
}
