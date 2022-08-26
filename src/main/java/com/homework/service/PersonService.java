package com.homework.service;

import com.homework.domain.PersonEntity;
import com.homework.dto.PersonDto;
import com.homework.repository.PersonRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PersonService {

    private final PersonRepository personRepository;

    public List<PersonDto> findAll() {
        return personRepository.findAll().stream()
                .map(this::convert)
                .collect(Collectors.toList());
    }

    public List<PersonDto> findAllPersonByIdAndDateOfBirth(Long id, String dateOfBirth) {
        return personRepository.findAllByIdAndDateOfBirth(id, dateOfBirth).stream()
                .map(this::convert)
                .collect(Collectors.toList());
    }

    private PersonDto convert(PersonEntity entity) {
        return new PersonDto(entity.getId(), entity.getFirstName(), entity.getLastName(),
                entity.getGender(), entity.getDateOfBirth());
    }
}
