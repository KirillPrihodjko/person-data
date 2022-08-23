package com.homework.controller;

import com.homework.dto.PersonDto;
import com.homework.service.PersonService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/person")
public class PersonController {

    private final PersonService personService;

    @PostMapping
    PersonDto create(@RequestBody @Valid PersonDto personDto) {
        log.info("Received create data request: {}", personDto);
        return personService.save(personDto);
    }

    @GetMapping("/{id}")
    PersonDto findById(@PathVariable Long id) {
        log.info("Received find book by id request, id: {}", id);
        return personService.findPersonById(id);

    }
}
