package com.homework.service;

import com.homework.domain.PersonEntity;
import com.homework.dto.PersonDto;
import com.homework.repository.PersonRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PersonServiceTest {

    @Mock
    private PersonRepository repository;

    @InjectMocks
    private PersonService service;

    @Test
    void shouldFindAllPersons() {
        var returnResult = entitiesSecond();
        when(repository.findAll()).thenReturn(returnResult);

        var result = service.findAll();

        var expectedResult = response();

        assertEquals(expectedResult, result);
    }

    private List<PersonEntity> entitiesSecond() {
        var returnEntity = new PersonEntity();
        returnEntity.setId(1);
        returnEntity.setFirstName("Test firstname");
        returnEntity.setLastName("Test lastname");
        returnEntity.setGender("Test gender");
        returnEntity.setDateOfBirth("Test dateOfBirth");
        return List.of(returnEntity);
    }

    private List<PersonDto> response() {
        var dto = new PersonDto(1, "Test firstname",
                "Test lastname", "Test gender", "Test dateOfBirth");
        return List.of(dto);
    }
}
