package com.homework.controller;

import com.homework.service.PersonService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@AllArgsConstructor
@RequestMapping("/ui")
class PersonUiController {

    private final PersonService personService;

    @PostMapping("/findPersons")
    public String findPersonsById(@ModelAttribute Long id, String dateOfBirth,Model model) {
        var response = personService.findPersonByIdAndDateOfBirth(id, dateOfBirth);
        model.addAttribute("persons", response);
        return "findPersons";
    }
}
