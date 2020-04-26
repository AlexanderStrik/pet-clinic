package com.alexanders.petclinic.services.db;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import com.alexanders.petclinic.model.Speciality;
import com.alexanders.petclinic.repository.SpecialityRepository;
import com.alexanders.petclinic.services.SpecialityService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
@Profile("db-data")
public class SpecialityDbService implements SpecialityService {

    private final SpecialityRepository specialityRepository;

    @Override
    public Speciality findById(Long id) {
        return specialityRepository.findById(id).orElse(null);
    }

    @Override
    public Set<Speciality> findAll() {
        return StreamSupport.stream(specialityRepository.findAll().spliterator(), false).collect(Collectors.toSet());
    }

    @Override
    public Speciality save(Speciality speciality) {
        return specialityRepository.save(speciality);
    }

    @Override
    public void delete(Speciality speciality) {
        specialityRepository.delete(speciality);
    }

    @Override
    public void deleteById(Long id) {
        specialityRepository.deleteById(id);
    }
}
