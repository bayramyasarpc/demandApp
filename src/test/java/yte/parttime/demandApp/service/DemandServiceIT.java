package yte.parttime.demandApp.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import yte.parttime.demandApp.configuration.DatabasePopulator;
import yte.parttime.demandApp.entity.Person;
import yte.parttime.demandApp.entity.demands.Ydemand;
import yte.parttime.demandApp.message.MessageResponse;
import yte.parttime.demandApp.repository.DemandRepository;
import yte.parttime.demandApp.repository.PersonRepository;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@DataJpaTest
public class DemandServiceIT {

    @Autowired
    DatabasePopulator databasePopulator;

    @Autowired
    DemandRepository demandRepository;

    @Autowired
    PersonRepository personRepository;

    @BeforeEach
    void setUp() {
        Person person =new Person("bayram","yasar","bayram@gmail.com");
        personRepository.save(person);
    }

    @Test
    void addYdemand() {
        DemandService demandService =new DemandService(demandRepository,personRepository);

        Optional<Person> person = personRepository.findById(1L);
        assertThat(person).isNotEmpty();


    }
}
