package yte.parttime.demandApp.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.springframework.security.core.parameters.P;
import yte.parttime.demandApp.configuration.DatabasePopulator;
import yte.parttime.demandApp.controller.request.AuthorityRequest;
import yte.parttime.demandApp.entity.Person;
import yte.parttime.demandApp.message.MessageResponse;
import yte.parttime.demandApp.repository.PersonRepository;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class PersonServiceTest {

    @Mock
    PersonRepository personRepository;

    @Mock
    DatabasePopulator databasePopulator;

    @InjectMocks
    PersonService personService;

//    @Test
//    void addPerson() {
//        Person person = new Person();
//        when(personRepository.save(person)).thenReturn(person);
//
//        MessageResponse messageResponse = personService.addPerson(person);
//        assertThat(messageResponse.getMessage()).isEqualTo("person saved successfully!");
//
//    }

//    @Test
//    void testGiveAuthorityPersonFound() {
//        Person person = new Person();
//        AuthorityRequest authorityRequest = new AuthorityRequest();
//        when(personRepository.findByFirstnameAndLastname(authorityRequest.getFirstName(), authorityRequest.getLastName())).thenReturn(person);
//
//        String view = personService.giveAuthority(authorityRequest);
//        assertEquals("authority verildi", view);
//    }
//
//    @Test
//    void testGiveAuthorityPersonNotFound() {
//        AuthorityRequest authorityRequest = new AuthorityRequest();
//        when(personRepository.findByFirstnameAndLastname(authorityRequest.getFirstName(), authorityRequest.getLastName())).thenReturn(null);
//        String giveAuthority = personService.giveAuthority(authorityRequest);
//        assertThat(giveAuthority).isEqualTo("person not found");
//    }
}