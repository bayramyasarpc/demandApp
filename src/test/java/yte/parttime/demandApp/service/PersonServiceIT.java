package yte.parttime.demandApp.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import yte.parttime.demandApp.entity.Person;
import yte.parttime.demandApp.message.MessageResponse;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@SpringBootTest
//@DataJpaTest
public class PersonServiceIT {

    @Autowired
    PersonService personService;

//    @Test
//    void addPerson() {
//        Person person = new Person();
//        person.setFirstName("yeliz");
//        person.setLastName("yemez");
//        person.setEmail("bayram@gmail.com");
//
//        MessageResponse messageResponse = personService.addPerson(person);
//        assertThat(messageResponse.getMessage()).isEqualTo("person saved successfully!");
//        assertTrue(person.getId()>0);
//    }
}
