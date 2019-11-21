package com.alexanders.petclinic.service;

import java.util.Set;

import com.alexanders.petclinic.model.Vet;

public interface VetService {

    Vet findById(long id);

    Set<Vet> findAll();

    Vet save(Vet Vet);
}
