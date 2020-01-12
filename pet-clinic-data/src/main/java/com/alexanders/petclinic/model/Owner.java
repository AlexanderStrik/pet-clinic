package com.alexanders.petclinic.model;

import java.util.Set;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Owner extends Person {

    private String address;
    private String city;
    private String telephone;
    private Set<Pet> pets;

    public Owner(String firstName, String lastName) {
        super(firstName, lastName);
    }
}
