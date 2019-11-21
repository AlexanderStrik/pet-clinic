package com.alexanders.petclinic.service;

import java.util.Set;

import com.alexanders.petclinic.model.Owner;

public interface OwnerService {

    Owner findByLastName(String lastName);

    Owner findById(long id);

    Set<Owner> findAll();

    Owner save(Owner owner);
}
