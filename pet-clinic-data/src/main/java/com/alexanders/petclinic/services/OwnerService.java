package com.alexanders.petclinic.services;

import com.alexanders.petclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long> {

    Owner findByLastName(String lastName);
}
