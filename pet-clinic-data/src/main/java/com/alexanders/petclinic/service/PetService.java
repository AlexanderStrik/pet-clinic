package com.alexanders.petclinic.service;

import java.util.Set;

import com.alexanders.petclinic.model.Pet;

public interface PetService {

    Pet findById(long id);

    Set<Pet> findAll();

    Pet save(Pet Pet);
}
