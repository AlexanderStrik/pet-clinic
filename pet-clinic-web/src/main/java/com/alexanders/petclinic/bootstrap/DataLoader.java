package com.alexanders.petclinic.bootstrap;

import java.time.LocalDate;

import com.alexanders.petclinic.model.Owner;
import com.alexanders.petclinic.model.Pet;
import com.alexanders.petclinic.model.PetType;
import com.alexanders.petclinic.model.Speciality;
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
        if (ownerService.findAll().size() == 0) {
            loadData();
        }
    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("Dog");

        PetType cat = new PetType();
        cat.setName("Cat");

        Speciality radiology = new Speciality();
        radiology.setDescription("Radiology");

        Speciality surgery = new Speciality();
        surgery.setDescription("Surgery");

        Speciality dentistry = new Speciality();
        dentistry.setDescription("Dentistry");

        Owner michael = new Owner("Michael", "Weston");
        michael.setAddress("123 Brickerel");
        michael.setCity("Miami");
        michael.setTelephone("1235444555");

        Pet michaelDog = new Pet();
        michaelDog.setName("Valodia");
        michaelDog.setBirthDate(LocalDate.now().minusDays(30));
        michaelDog.setOwner(michael);
        michaelDog.setPetType(dog);
        michael.getPets().add(michaelDog);

        ownerService.save(michael);

        Owner fiona = new Owner("Fiona", "Glenanne");
        fiona.setAddress("456 Brickerel");
        fiona.setCity("Miami Beach");
        fiona.setTelephone("554446666");

        Pet fionaCat = new Pet();
        fionaCat.setName("Marina");
        fionaCat.setBirthDate(LocalDate.now().minusDays(15));
        fionaCat.setOwner(fiona);
        fionaCat.setPetType(cat);
        fiona.getPets().add(fionaCat);

        ownerService.save(fiona);

        System.out.println("Loaded Owners...");

        Vet vet1 = new Vet("Sam", "Axe");
        vet1.getSpecialities().add(radiology);
        vetService.save(vet1);

        Vet vet2 = new Vet("Jessie", "Porter");
        vet2.getSpecialities().add(surgery);
        vetService.save(vet2);

        System.out.println("Loaded Vets...");
    }
}
