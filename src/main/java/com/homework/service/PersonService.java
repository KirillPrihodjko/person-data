package com.homework.service;

import com.homework.domain.PersonEntity;
import com.homework.dto.PersonDto;
import com.homework.repository.PersonRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@NoArgsConstructor
@AllArgsConstructor
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public List<PersonDto> findAll() {
        return personRepository.findAll().stream()
                .map(this::convert)
                .collect(Collectors.toList());
    }

    public List<PersonDto> findAllPersonByIdAndDateOfBirth(Integer id, String dateOfBirth) {
        return personRepository.findAllByIdAndDateOfBirth(id, dateOfBirth).stream()
                .map(this::convert)
                .collect(Collectors.toList());
    }

    private PersonDto convert(PersonEntity entity) {
        return new PersonDto(entity.getId(), entity.getFirstName(), entity.getLastName(),
                entity.getGender(), entity.getDateOfBirth());
    }
}
