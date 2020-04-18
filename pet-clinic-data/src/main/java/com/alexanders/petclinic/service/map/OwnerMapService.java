package com.alexanders.petclinic.service.map;

import java.util.Objects;

import com.alexanders.petclinic.model.Owner;
import com.alexanders.petclinic.model.Pet;
import com.alexanders.petclinic.model.PetType;
import com.alexanders.petclinic.service.OwnerService;
import com.alexanders.petclinic.service.PetService;
import com.alexanders.petclinic.service.PetTypeService;
import org.springframework.stereotype.Service;

@Service
public class OwnerMapService extends AbstractMapService<Owner, Long> implements OwnerService {

    private final PetService petService;
    private final PetTypeService petTypeService;

    public OwnerMapService(PetService petService, PetTypeService petTypeService) {
        this.petService = petService;
        this.petTypeService = petTypeService;
    }

    @Override
    public Owner save(Owner owner) {
        if (Objects.isNull(owner)) {
            return null;
        }
        if (Objects.nonNull(owner.getPets())) {
            owner.getPets().forEach(pet -> {
                if (pet.getPetType() != null) {
                    if (pet.getPetType().getId() == null) {
                        PetType savedPetType = petTypeService.save(pet.getPetType());
                        pet.setPetType(savedPetType);
                    }
                } else {
                    throw new RuntimeException("Pet type is required");
                }
                if (pet.getId() == null) {
                    Pet savedPet = petService.save(pet);
                    pet.setId(savedPet.getId());
                }
            });
        }
        return super.save(owner);
    }

    @Override
    public Owner findByLastName(String lastName) {
        return map.entrySet()
                  .stream()
                  .filter(entry -> lastName.equals(entry.getValue().getLastName()))
                  .findFirst()
                  .orElseThrow(() -> new RuntimeException(String.format("Owner with last name %s wasn't found", lastName)))
                  .getValue();
    }
}
