package com.alexanders.petclinic.bootstrap;

import com.alexanders.petclinic.model.Owner;
import com.alexanders.petclinic.model.PetType;
import com.alexanders.petclinic.model.Vet;
import com.alexanders.petclinic.service.OwnerService;
import com.alexanders.petclinic.service.PetTypeService;
import com.alexanders.petclinic.service.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) {
        PetType dog = new PetType();
        dog.setName("Dog");

        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");

        PetType savedCatPetType = petTypeService.save(cat);

        Owner owner1 = new Owner("Michael", "Weston");
        ownerService.save(owner1);

        Owner owner2 = new Owner("Fiona", "Glenanne");
        ownerService.save(owner2);

        System.out.println("Loaded Owners...");

        Vet vet1 = new Vet("Sam", "Axe");
        vetService.save(vet1);

        Vet vet2 = new Vet("Jessie", "Porter");
        vetService.save(vet2);

        System.out.println("Loaded Vets...");
    }
}
