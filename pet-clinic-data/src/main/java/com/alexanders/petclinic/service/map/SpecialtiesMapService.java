package com.alexanders.petclinic.service.map;

import com.alexanders.petclinic.model.Speciality;
import com.alexanders.petclinic.service.SpecialtiesService;
import org.springframework.stereotype.Service;

@Service
public class SpecialtiesMapService extends AbstractMapService<Speciality, Long> implements SpecialtiesService {
}
