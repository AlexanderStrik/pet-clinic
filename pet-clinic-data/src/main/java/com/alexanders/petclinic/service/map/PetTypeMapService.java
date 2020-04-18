package com.alexanders.petclinic.service.map;

import com.alexanders.petclinic.model.PetType;
import com.alexanders.petclinic.service.PetTypeService;
import org.springframework.stereotype.Service;

@Service
public class PetTypeMapService extends AbstractMapService<PetType, Long> implements PetTypeService {
}