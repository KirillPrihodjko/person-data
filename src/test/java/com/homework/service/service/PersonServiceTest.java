package com.homework.service.service;

import com.homework.domain.PersonEntity;
import com.homework.dto.PersonDto;
import com.homework.repository.PersonRepository;
import com.homework.service.PersonService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PersonServiceTest {

    @Mock
    private PersonRepository repository;

    @InjectMocks
    private PersonService service;

    private static List<PersonDto> expectedResponse;

    private static List<PersonEntity> entities;

    @BeforeAll
    public static void entity() {
        var dto = new PersonDto(1, "Test firstname",
                "Test lastname", "Test gender", "Test dateOfBirth");
        expectedResponse = List.of(dto);
        var returnEntity = new PersonEntity();
        returnEntity.setId(1);
        returnEntity.setFirstName("Test firstname");
        returnEntity.setLastName("Test lastname");
        returnEntity.setGender("Test gender");
        returnEntity.setDateOfBirth("Test dateOfBirth");
        entities = List.of(returnEntity);
    }

    @Test
    @DisplayName("Test method findAllPersons")
    void shouldFindAllPersons() {
        when(repository.findAll()).thenReturn(entities);
        assertEquals(expectedResponse, service.findAll());
    }
}
