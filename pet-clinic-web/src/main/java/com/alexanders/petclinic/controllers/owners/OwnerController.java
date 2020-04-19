package com.alexanders.petclinic.controllers.owners;

import com.alexanders.petclinic.service.OwnerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@AllArgsConstructor
public class OwnerController {

    private final OwnerService ownerService;

    @RequestMapping(
            method = RequestMethod.GET,
            path = {"/owners", "/owners.html", "/owners/index", "/owners/index.html"}
    )
    public String getOwners(Model model) {
        model.addAttribute("owners", ownerService.findAll());
        return "owners/index";
    }

    @RequestMapping(
            method = RequestMethod.GET,
            path = "/owners/find"
    )
    public String findOwners() {
        return "notimplemented";
    }
}
