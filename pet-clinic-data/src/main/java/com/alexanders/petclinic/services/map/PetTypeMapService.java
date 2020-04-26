package com.alexanders.petclinic.services.map;

import com.alexanders.petclinic.model.PetType;
import com.alexanders.petclinic.services.PetTypeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile({"default", "map-data"})
public class PetTypeMapService extends AbstractMapService<PetType, Long> implements PetTypeService {
}