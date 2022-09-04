package com.homework.service.controller;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.DatabaseTearDown;
import com.homework.domain.PersonEntity;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
@TestExecutionListeners(listeners = {DependencyInjectionTestExecutionListener.class, DbUnitTestExecutionListener.class},
        mergeMode = TestExecutionListeners.MergeMode.MERGE_WITH_DEFAULTS)
class PersonControllerTestITSecond {

    @Autowired
    private MockMvc mockMvc;

    private final PersonEntity person = new PersonEntity(2, "test",
            "test", "test", "04/01/2000");

    @Test
    void testFindAll() throws Exception {

        mockMvc.perform(get("/ui/findAllPersons/")).
                andDo(print()).andExpect(view().
                name("findAllPersons"));
    }

    @Test
    @DatabaseSetup(value = "classpath:dbunit/find-person-dataset.xml")
    @DatabaseTearDown(value = "classpath:dbunit/find-person-dataset.xml")
    void testFindPerson() throws Exception {

        mockMvc.perform(get("/ui/findPersons/").
                param("id", "2").
                param("dateOfBirth", "04/01/2000").flashAttr("persons", List.of(person))).
                andDo(print()).andExpect(view().
                name("findPersons"));
    }
}
