package com.homework.controller;

import com.homework.service.PersonService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@AllArgsConstructor
@RequestMapping("/ui")
class PersonUiController {

    private final PersonService personService;

    @GetMapping("/findPersons")
    public String findPersonsById(@ModelAttribute Long id, String dateOfBirth, Model model) {
        var response = personService.findAllPersonByIdAndDateOfBirth(id, dateOfBirth);
        model.addAttribute("persons", response);
        return "redirect:/ui/findAllPersons";
    }

    @GetMapping("/findAllPersons")
    public String findAllPerson(Model model) {
        var response = personService.findAll();
        model.addAttribute("persons", response);
        return "findAllPersons";
    }
}
