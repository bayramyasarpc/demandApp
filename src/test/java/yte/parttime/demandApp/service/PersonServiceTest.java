package yte.parttime.demandApp.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.springframework.security.crypto.password.PasswordEncoder;
import yte.parttime.demandApp.entity.Person;
import yte.parttime.demandApp.entity.Users;
import yte.parttime.demandApp.message.MessageResponse;
import yte.parttime.demandApp.repository.PersonRepository;
import yte.parttime.demandApp.repository.UserRepository;


import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class PersonServiceTest {

    @Mock
    PersonRepository personRepository;

    @Mock
    PasswordEncoder passwordEncoder;

    @Mock
    UserRepository userRepository;

    @InjectMocks
    PersonService personService;

    @Test
    void addPerson() {
        Person person = new Person();
        Users users=new Users();
        when(personRepository.save(person)).thenReturn(person);
        when(userRepository.save(users)).thenReturn(users);

        MessageResponse messageResponse = personService.addPerson(person,"USER");
        assertThat(messageResponse.getMessage()).isEqualTo("person saved successfully!");

    }

}