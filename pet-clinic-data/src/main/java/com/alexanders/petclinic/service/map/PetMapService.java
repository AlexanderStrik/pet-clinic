package com.alexanders.petclinic.service.map;

import com.alexanders.petclinic.model.Pet;
import com.alexanders.petclinic.service.PetService;
import org.springframework.stereotype.Service;

@Service
public class PetMapService extends AbstractMapService<Pet, Long> implements PetService {
}
