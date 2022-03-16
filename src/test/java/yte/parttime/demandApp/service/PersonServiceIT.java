package yte.parttime.demandApp.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import yte.parttime.demandApp.entity.Person;
import yte.parttime.demandApp.message.MessageResponse;
import yte.parttime.demandApp.repository.PersonRepository;
import yte.parttime.demandApp.repository.UserRepository;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

//@SpringBootTest
@DataJpaTest
public class PersonServiceIT {

    @Autowired
    PersonRepository personRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    PasswordEncoder passwordEncoder;


    @Test
    void addPersonAuthorityUSER() {
        Person person = new Person();
        person.setFirstName("yeliz");
        person.setLastName("yemez");
        person.setEmail("bayram@gmail.com");

        PersonService personService =new PersonService(personRepository,userRepository,passwordEncoder);

        MessageResponse messageResponse = personService.addPerson(person,"USER");

        assertThat(messageResponse.getMessage()).isEqualTo("person saved successfully!");
    }
    @Test
    void addPersonAuthorityADMIN(){
        Person person= new Person("bayram","yasar","bayram@gmail.com");

        PersonService personService=new PersonService(personRepository,userRepository,passwordEncoder);
        MessageResponse messageResponse = personService.addPerson(person, "ADMIN");
        assertThat(messageResponse.getMessage()).isEqualTo("person saved successfully!");
    }
}
