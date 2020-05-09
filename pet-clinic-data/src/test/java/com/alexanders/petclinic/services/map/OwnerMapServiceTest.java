package com.alexanders.petclinic.services.map;

import java.util.Set;

import com.alexanders.petclinic.model.Owner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class OwnerMapServiceTest {

    private static final String NAME = "Valera";

    private OwnerMapService ownerMapService;

    @BeforeEach
    void setUp() {
        ownerMapService = new OwnerMapService(new PetMapService(), new PetTypeMapService());
        Owner owner1 = Owner.builder().id(1L).lastName(NAME).build();
        Owner owner2 = Owner.builder().id(2L).build();
        ownerMapService.getMap().put(owner1.getId(), owner1);
        ownerMapService.getMap().put(owner2.getId(), owner2);
    }

    @Test
    void findAll() {
        Set<Owner> owners = ownerMapService.findAll();
        assertThat(owners.size()).isEqualTo(2);
    }

    @Test
    void findById() {
        Owner owner = ownerMapService.findById(2L);
        assertThat(owner.getId()).isEqualTo(2L);
    }

    @Test
    void save() {
        Owner owner = Owner.builder().id(3L).build();
        Owner savedOwner = ownerMapService.save(owner);
        assertThat(savedOwner.getId()).isEqualTo(3L);
        assertThat(ownerMapService.getMap().size()).isEqualTo(3);
    }

    @Test
    void saveWithNoId() {
        Owner owner = Owner.builder().build();
        Owner savedOwner = ownerMapService.save(owner);
        assertThat(savedOwner.getId()).isEqualTo(3L);
        assertThat(ownerMapService.getMap().size()).isEqualTo(3);
    }

    @Test
    void delete() {
        Owner owner2delete = Owner.builder().id(2L).build();
        ownerMapService.delete(owner2delete);
        assertThat(ownerMapService.getMap().size()).isEqualTo(1);
        assertThat(ownerMapService.getMap().get(2L)).isNull();
    }

    @Test
    void deleteById() {
        Owner owner2delete = Owner.builder().id(1L).build();
        ownerMapService.deleteById(owner2delete.getId());
        assertThat(ownerMapService.getMap().size()).isEqualTo(1);
        assertThat(ownerMapService.getMap().get(1L)).isNull();
    }

    @Test
    void findByLastName() {
        Owner valera = ownerMapService.findByLastName(NAME);
        assertThat(valera.getId()).isEqualTo(1L);
        assertThat(valera.getLastName()).isEqualTo(NAME);
    }

    @Test
    void findByNotExistingLastNameReturnsNull() {
        Owner valera = ownerMapService.findByLastName("abyrvalg");
        assertThat(valera).isNull();
    }
}