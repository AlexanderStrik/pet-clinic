package com.alexanders.petclinic.controllers.owners;

import java.util.HashSet;

import com.alexanders.petclinic.model.Owner;
import com.alexanders.petclinic.services.OwnerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@ExtendWith(MockitoExtension.class)
class OwnerControllerTest {

    @InjectMocks
    OwnerController ownerController;
    @Mock
    OwnerService ownerService;

    MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(ownerController).build();
    }

    @Test
    void findOwners() throws Exception {
        mockMvc.perform(get("/owners/find"))
               .andExpect(status().isOk())
               .andExpect(view().name("notimplemented"));
        verifyNoMoreInteractions(ownerService);
    }

    @Test
    void getOwners() throws Exception {
        checkGetOwners("/owners");
    }

    @Test
    void getOwnersIndex() throws Exception {
        checkGetOwners("/owners/index");
    }

    private void checkGetOwners(String path) throws Exception {
        HashSet<Owner> owners = new HashSet<>();
        when(ownerService.findAll()).thenReturn(owners);
        mockMvc.perform(get(path))
               .andExpect(status().isOk())
               .andExpect(view().name("owners/index"))
               .andExpect(model().attribute("owners", owners))
               .andExpect(model().attribute("owners", hasSize(owners.size())));
        verify(ownerService).findAll();
    }
}