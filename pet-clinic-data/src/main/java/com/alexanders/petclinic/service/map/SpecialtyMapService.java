package com.alexanders.petclinic.service.map;

import com.alexanders.petclinic.model.Speciality;
import com.alexanders.petclinic.service.SpecialtyService;
import org.springframework.stereotype.Service;

@Service
public class SpecialtyMapService extends AbstractMapService<Speciality, Long> implements SpecialtyService {
}
