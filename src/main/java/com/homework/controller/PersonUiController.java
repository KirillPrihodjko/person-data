package com.homework.controller;

import com.homework.dto.PersonDto;
import com.homework.service.PersonService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Slf4j
@Controller
@AllArgsConstructor
@Data
@RequestMapping("/ui")
public class PersonUiController {

    private final PersonService personService;

    @GetMapping("/findPersons")
    public String findPersonById(@RequestParam(value = "id", required = false) Integer id,
                                 @RequestParam("dateOfBirth") String dateOfBirth, Model model) {
        log.info("Received find persons by id and dateOfBirth request: {} {}", id, dateOfBirth);
        var response = personService.findAllPersonByIdAndDateOfBirth(id, dateOfBirth);
        model.addAttribute("persons", response);
        return "findPersons";
    }

    @GetMapping("/findAllPersons")
    public String findAllPerson(Model model) {
        log.info("Received find all persons request");
        model.addAttribute("person", new PersonDto());
        return "findAllPersons";
    }
}
