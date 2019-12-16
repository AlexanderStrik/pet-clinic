package com.alexanders.petclinic.bootstrap;

import com.alexanders.petclinic.model.Owner;
import com.alexanders.petclinic.model.Vet;
import com.alexanders.petclinic.service.OwnerService;
import com.alexanders.petclinic.service.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) {
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
