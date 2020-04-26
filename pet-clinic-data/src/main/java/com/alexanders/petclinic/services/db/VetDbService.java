package com.alexanders.petclinic.services.db;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import com.alexanders.petclinic.model.Vet;
import com.alexanders.petclinic.repository.VetRepository;
import com.alexanders.petclinic.services.VetService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
@Profile("db-data")
public class VetDbService implements VetService {

    private final VetRepository vetRepository;

    @Override
    public Vet findById(Long id) {
        return vetRepository.findById(id).orElse(null);
    }

    @Override
    public Set<Vet> findAll() {
        return StreamSupport.stream(vetRepository.findAll().spliterator(), false).collect(Collectors.toSet());
    }

    @Override
    public Vet save(Vet vet) {
        return vetRepository.save(vet);
    }

    @Override
    public void delete(Vet vet) {
        vetRepository.delete(vet);
    }

    @Override
    public void deleteById(Long id) {
        vetRepository.deleteById(id);
    }
}
