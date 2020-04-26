package com.alexanders.petclinic.services.db;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import com.alexanders.petclinic.model.Pet;
import com.alexanders.petclinic.repository.PetRepository;
import com.alexanders.petclinic.services.PetService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
@Profile("db-data")
public class PetDbService implements PetService {

    private final PetRepository petRepository;

    @Override
    public Pet findById(Long id) {
        return petRepository.findById(id).orElse(null);
    }

    @Override
    public Set<Pet> findAll() {
        return StreamSupport.stream(petRepository.findAll().spliterator(), false).collect(Collectors.toSet());
    }

    @Override
    public Pet save(Pet pet) {
        return petRepository.save(pet);
    }

    @Override
    public void delete(Pet pet) {
        petRepository.delete(pet);
    }

    @Override
    public void deleteById(Long id) {
        petRepository.deleteById(id);
    }
}
