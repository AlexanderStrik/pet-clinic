package com.alexanders.petclinic.service.map;

import com.alexanders.petclinic.model.Vet;
import com.alexanders.petclinic.service.VetService;
import org.springframework.stereotype.Service;

@Service
public class VetMapService extends AbstractMapService<Vet, Long> implements VetService {
}
