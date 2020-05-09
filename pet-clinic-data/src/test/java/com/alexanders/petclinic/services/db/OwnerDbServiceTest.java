package com.alexanders.petclinic.services.db;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import com.alexanders.petclinic.model.Owner;
import com.alexanders.petclinic.repository.OwnerRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class OwnerDbServiceTest {

    @InjectMocks
    private OwnerDbService ownerDbService;
    @Mock
    private OwnerRepository ownerRepository;

    @Test
    void findByLastName() {
        final String lastName = "Valerin";
        when(ownerRepository.findFirstByLastName(any())).thenReturn(Owner.builder().id(1L).lastName(lastName).build());
        Owner owner = ownerDbService.findByLastName(lastName);
        assertThat(owner.getLastName()).isEqualTo(lastName);
        verify(ownerRepository).findFirstByLastName(any());
    }

    @Test
    void findById() {
        final long id = 1L;
        when(ownerRepository.findById(any())).thenReturn(Optional.of(Owner.builder().id(id).build()));
        Owner owner = ownerDbService.findById(id);
        assertThat(owner.getId()).isEqualTo(id);
        verify(ownerRepository).findById(any());
    }

    @Test
    void findByNotExistingId() {
        when(ownerRepository.findById(any())).thenReturn(Optional.empty());
        Owner owner = ownerDbService.findById(any());
        assertThat(owner).isNull();
        verify(ownerRepository).findById(any());
    }

    @Test
    void findAll() {
        Set<Owner> ownerSet = new HashSet<>();
        ownerSet.add(Owner.builder().build());
        when(ownerRepository.findAll()).thenReturn(ownerSet);
        Set<Owner> owners = ownerDbService.findAll();
        assertThat(owners).isEqualTo(ownerSet);
        verify(ownerRepository).findAll();
    }

    @Test
    void save() {
        Owner owner = Owner.builder().build();
        when(ownerRepository.save(any())).thenReturn(owner);
        Owner savedOwner = ownerDbService.save(any());
        assertThat(savedOwner).isEqualTo(owner);
        verify(ownerRepository).save(any());
    }

    @Test
    void delete() {
        ownerDbService.delete(any());
        verify(ownerRepository).delete(any());
    }

    @Test
    void deleteById() {
        ownerDbService.deleteById(any());
        verify(ownerRepository).deleteById(any());
    }
}