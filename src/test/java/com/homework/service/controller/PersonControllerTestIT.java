package com.homework.service.controller;

import com.homework.controller.PersonUiController;
import com.homework.domain.PersonEntity;
import com.homework.repository.PersonRepository;
import com.homework.service.PersonService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc
@WebAppConfiguration
class PersonControllerTestIT {

    private static MockMvc mockMvc;

    private static final PersonRepository personRepository = Mockito.mock(PersonRepository.class);
    private static final PersonEntity person = new PersonEntity(1, "Test firstname",
            "Test lastname", "Test gender", "Test dateOfBirth");

    @BeforeAll
    public static void setup() {
        when(personRepository.findAllByIdAndDateOfBirth(1, "04/01/2000")).thenReturn(List.of(person));
        mockMvc = MockMvcBuilders.standaloneSetup(new PersonUiController(new PersonService(personRepository))).build();
    }

    @Test
    void testFindAll() throws Exception {
        mockMvc.perform(get("/ui/findAllPersons/")).
                andDo(print()).andExpect(view().
                name("findAllPersons"));
    }

    @Test
    void testFindPerson() throws Exception {
        mockMvc.perform(get("/ui/findPersons/").
                param("id", "1").
                param("dateOfBirth", "04/01/2000")).
                andDo(print()).andExpect(view().
                name("findPersons"));
    }
}
