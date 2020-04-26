package com.alexanders.petclinic.services.map;

import com.alexanders.petclinic.model.Speciality;
import com.alexanders.petclinic.services.SpecialityService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile({"default", "map-data"})
public class SpecialityMapService extends AbstractMapService<Speciality, Long> implements SpecialityService {
}
