package com.homework.service;

import com.homework.domain.PersonEntity;
import com.homework.dto.FindByIdAndDateOfBirthPersonResponse;
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
    void shouldFindPersonByIdAndDateOfBirth() {
        var returnResult = entities();
        when(repository.findAll()).thenReturn(returnResult);

        long id = 1;
        String dateOfBirth = "04/01/2000";

        var result = service.findPersonByIdAndDateOfBirth(id, dateOfBirth);

        var expectedResult = response();

        assertEquals(expectedResult, result);
    }

    private List<PersonEntity> entities() {
        var returnEntity = new PersonEntity();
        returnEntity.setId(1L);
        returnEntity.setDateOfBirth("04/01/2000");
        return List.of(returnEntity);
    }

    private FindByIdAndDateOfBirthPersonResponse response() {
        var dto = new PersonDto(1L, "Test FirstName",
                "Test LastName", "Test Gender", "Test DateOfBirth");
        return new FindByIdAndDateOfBirthPersonResponse((List.of(dto)));
    }
}