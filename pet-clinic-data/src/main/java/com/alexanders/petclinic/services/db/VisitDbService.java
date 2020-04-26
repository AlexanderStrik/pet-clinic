package com.alexanders.petclinic.services.db;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import com.alexanders.petclinic.model.Visit;
import com.alexanders.petclinic.repository.VisitRepository;
import com.alexanders.petclinic.services.VisitService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
@Profile("db-data")
public class VisitDbService implements VisitService {

    private final VisitRepository visitRepository;

    @Override
    public Visit findById(Long id) {
        return visitRepository.findById(id).orElse(null);
    }

    @Override
    public Set<Visit> findAll() {
        return StreamSupport.stream(visitRepository.findAll().spliterator(), false).collect(Collectors.toSet());
    }

    @Override
    public Visit save(Visit visit) {
        return visitRepository.save(visit);
    }

    @Override
    public void delete(Visit visit) {
        visitRepository.delete(visit);
    }

    @Override
    public void deleteById(Long id) {
        visitRepository.deleteById(id);
    }
}
