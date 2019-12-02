package com.alexanders.petclinic.service.map;

import com.alexanders.petclinic.model.Owner;
import com.alexanders.petclinic.service.OwnerService;
import org.springframework.stereotype.Service;

@Service
public class OwnerMapService extends AbstractMapService<Owner, Long> implements OwnerService {


    @Override
    public Owner save(Owner owner) {
        return super.save(owner.getId(), owner);
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
