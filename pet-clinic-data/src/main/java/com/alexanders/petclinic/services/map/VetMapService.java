package com.alexanders.petclinic.services.map;

import com.alexanders.petclinic.model.Speciality;
import com.alexanders.petclinic.model.Vet;
import com.alexanders.petclinic.services.SpecialityService;
import com.alexanders.petclinic.services.VetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile({"default", "map-data"})
public class VetMapService extends AbstractMapService<Vet, Long> implements VetService {

    private final SpecialityService specialityService;

    public VetMapService(SpecialityService specialityService) {
        this.specialityService = specialityService;
    }

    @Override
    public Vet save(Vet vet) {
        if (vet == null) {
            return null;
        }
        if (vet.getSpecialities() != null) {
            vet.getSpecialities().forEach(speciality -> {
                if (speciality.getId() == null) {
                    Speciality savedSpecialty = specialityService.save(speciality);
                    speciality.setId(savedSpecialty.getId());
                }
            });
        }
        return super.save(vet);
    }
}
