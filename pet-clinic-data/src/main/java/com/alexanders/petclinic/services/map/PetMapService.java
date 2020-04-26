package com.alexanders.petclinic.services.map;

import com.alexanders.petclinic.model.Pet;
import com.alexanders.petclinic.services.PetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile({"default", "map-data"})
public class PetMapService extends AbstractMapService<Pet, Long> implements PetService {
}
