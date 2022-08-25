package com.homework.service;

import com.homework.domain.PersonEntity;
import com.homework.dto.PersonDto;
import com.homework.repository.PersonRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PersonService {

    private final PersonRepository personRepository;

    public PersonDto save(PersonDto personDto) {
        var entity = convert(personDto);
        personRepository.save(entity);
        return convert(entity);
    }

    public PersonDto findPersonByIdAndDateOfBirth(Long id, String dateOfBirth) {
        return personRepository.findPersonByIdAndDateOfBirth(id, dateOfBirth).
                map(this::convert).
                orElseThrow(() -> new IllegalArgumentException("Person with id " + id + " is not found"));
    }

    private PersonEntity convert(PersonDto dto) {
        return new PersonEntity(dto.getId(), dto.getFirstName(), dto.getLastName(),
                dto.getGender(), dto.getDateOfBirth());
    }

    private PersonDto convert(PersonEntity entity) {
        return new PersonDto(entity.getId(), entity.getFirstName(), entity.getLastName(),
                entity.getGender(), entity.getDateOfBirth());
    }
}
