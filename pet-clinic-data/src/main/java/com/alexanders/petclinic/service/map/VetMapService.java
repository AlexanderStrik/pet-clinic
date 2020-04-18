package com.alexanders.petclinic.service.map;

import com.alexanders.petclinic.model.Speciality;
import com.alexanders.petclinic.model.Vet;
import com.alexanders.petclinic.service.SpecialtyService;
import com.alexanders.petclinic.service.VetService;
import org.springframework.stereotype.Service;

@Service
public class VetMapService extends AbstractMapService<Vet, Long> implements VetService {

    private final SpecialtyService specialtyService;

    public VetMapService(SpecialtyService specialtyService) {
        this.specialtyService = specialtyService;
    }

    @Override
    public Vet save(Vet vet) {
        if (vet == null) {
            return null;
        }
        if (vet.getSpecialities() != null) {
            vet.getSpecialities().forEach(speciality -> {
                if (speciality.getId() == null) {
                    Speciality savedSpecialty = specialtyService.save(speciality);
                    speciality.setId(savedSpecialty.getId());
                }
            });
        }
        return super.save(vet);
    }
}
