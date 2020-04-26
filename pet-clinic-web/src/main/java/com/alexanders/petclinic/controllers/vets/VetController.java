package com.alexanders.petclinic.controllers.vets;

import com.alexanders.petclinic.services.VetService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@AllArgsConstructor
public class VetController {

    private final VetService vetService;

    @RequestMapping(
            method = RequestMethod.GET,
            path = {"/vets", "/vets.html", "/vets/index", "/vets/index.html"}
    )
    public String getVets(Model model) {
        model.addAttribute("vets", vetService.findAll());
        return "vets/index";
    }
}
