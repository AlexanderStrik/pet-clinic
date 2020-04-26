package com.alexanders.petclinic.services.db;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import com.alexanders.petclinic.model.PetType;
import com.alexanders.petclinic.repository.PetTypeRepository;
import com.alexanders.petclinic.services.PetTypeService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
@Profile("db-data")
public class PetTypeDbService implements PetTypeService {

    private final PetTypeRepository petTypeRepository;

    @Override
    public PetType findById(Long id) {
        return petTypeRepository.findById(id).orElse(null);
    }

    @Override
    public Set<PetType> findAll() {
        return StreamSupport.stream(petTypeRepository.findAll().spliterator(), false).collect(Collectors.toSet());
    }

    @Override
    public PetType save(PetType petType) {
        return petTypeRepository.save(petType);
    }

    @Override
    public void delete(PetType petType) {
        petTypeRepository.delete(petType);
    }

    @Override
    public void deleteById(Long id) {
        petTypeRepository.deleteById(id);
    }
}
