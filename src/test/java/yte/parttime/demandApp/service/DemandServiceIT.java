package yte.parttime.demandApp.service;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import yte.parttime.demandApp.configuration.DatabasePopulator;
import yte.parttime.demandApp.entity.Demand;
import yte.parttime.demandApp.entity.Person;
import yte.parttime.demandApp.entity.demands.Xdemand;
import yte.parttime.demandApp.entity.demands.Ydemand;
import yte.parttime.demandApp.entity.demands.Zdemand;
import yte.parttime.demandApp.message.MessageResponse;
import yte.parttime.demandApp.repository.DemandRepository;
import yte.parttime.demandApp.repository.PersonRepository;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class DemandServiceIT {



    private Long personolID=0L;
    @Autowired
    DemandRepository demandRepository;

    @Autowired
    PersonRepository personRepository;

    @BeforeEach
    void setUp() {
        Person person =new Person("bayram","yasar","bayram@gmail.com");
        personRepository.save(person);
        System.out.println("Before-each");
        setPersonolID(person.getId());
        System.out.println(personolID);
    }

    @Test
    void addYdemand() {
        System.out.println("ydemand");
        DemandService demandService =new DemandService(demandRepository,personRepository);
        Ydemand ydemand=new Ydemand("ydemand","mentor",null,null,"123");

        MessageResponse messageResponse = demandService.addYdemand(getPersonolID(), ydemand);

        assertThat(messageResponse.getMessage()).isEqualTo("Ydemand %s has been added successfully!".formatted(getPersonolID()));
    }
    @Test
    void addZdemand(){
        System.out.println("zdemand");
        DemandService demandService =new DemandService(demandRepository,personRepository);
        Zdemand zdemand=new Zdemand("Zdemand","mentor",null,null,"zname");
        MessageResponse messageResponse = demandService.addZdemand(getPersonolID(), zdemand);
        assertThat(messageResponse.getMessage()).isEqualTo("Zdemand %s has been added successfully!".formatted(getPersonolID()));
    }
    @Test
    void  addXdemand(){
        System.out.println("xdemand");
        DemandService demandService=new DemandService(demandRepository,personRepository);
        Xdemand xdemand=new Xdemand("Xdemand","mentor",null,null,3.1);

        MessageResponse messageResponse = demandService.addXdemand(getPersonolID(), xdemand);
        assertThat(messageResponse.getMessage()).isEqualTo("Xdemand %s has been added successfully!".formatted(getPersonolID()));
    }
    public Long getPersonolID() {
        return personolID;
    }

    public void setPersonolID(Long personolID) {
        this.personolID = personolID;
    }
}
