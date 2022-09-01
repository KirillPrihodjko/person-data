package com.homework.controller;

import com.homework.dto.PersonDto;
import com.homework.service.PersonService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("rest/ui")
class PersonRestController {

    private final PersonService personService;

    @GetMapping("/findPersons")
    public PersonDto findPersonById(@RequestParam(value = "id", required = false) Integer id,
                                    @RequestParam("dateOfBirth") String dateOfBirth) {
        log.info("Received find persons by id and dateOfBirth request: {} {}", id, dateOfBirth);
        var response = personService.findAllPersonByIdAndDateOfBirth(id, dateOfBirth);
        return response.isEmpty() ? null : response.get(0);
    }

    @GetMapping("/findAllPersons")
    public String findAllPerson(Model model) {
        log.info("Received find all persons request");
        var response = personService.findAll();
        model.addAttribute("persons", response);
        return "findAllPersons";
    }
}
