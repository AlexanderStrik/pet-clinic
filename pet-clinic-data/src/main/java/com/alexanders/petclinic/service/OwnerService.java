package com.alexanders.petclinic.service;

import com.alexanders.petclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long> {

    Owner findByLastName(String lastName);
}
