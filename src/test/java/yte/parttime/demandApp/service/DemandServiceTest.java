package yte.parttime.demandApp.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import yte.parttime.demandApp.entity.Person;
import yte.parttime.demandApp.entity.demands.Xdemand;
import yte.parttime.demandApp.entity.demands.Ydemand;
import yte.parttime.demandApp.entity.demands.Zdemand;
import yte.parttime.demandApp.message.MessageResponse;
import yte.parttime.demandApp.repository.DemandRepository;
import yte.parttime.demandApp.repository.PersonRepository;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class DemandServiceTest {

    @InjectMocks
    DemandService demandService;

    @Mock
    DemandRepository demandRepository;
    @Mock
    PersonRepository personRepository;

    @Mock
    Person person;

    @BeforeEach
    void setUp() {
        person=new Person();
    }

    @Test
    void addYdemand() {
        Ydemand ydemand=new Ydemand();
        when(personRepository.findById(any())).thenReturn(Optional.of(person));

        MessageResponse messageResponse = demandService.addYdemand(1L, ydemand);
        assertThat(messageResponse.getMessage()).isEqualTo("Ydemand %s has been added successfully!".formatted(1L));

    }
    @Test
    void addYdemandNotFoundPerson() {
        Ydemand ydemand=new Ydemand();
        when(personRepository.findById(any())).thenReturn(Optional.empty());

        assertThatThrownBy(()->demandService.addYdemand(1L,ydemand))
                .isInstanceOf(EntityNotFoundException.class)
                .hasMessage("we dont have person %s".formatted(1));
    }

    @Test
    void addZdemand() {
        when(personRepository.findById(any())).thenReturn(Optional.ofNullable(person));

        MessageResponse messageResponse = demandService.addZdemand(1L, new Zdemand());

        assertThat(messageResponse.getMessage()).isEqualTo("Zdemand %s has been added successfully!".formatted(1L));
    }

    @Test
    void addZdemandNotFoundPerson() {
        when(personRepository.findById(any())).thenReturn(Optional.empty());

        assertThatThrownBy(()->demandService.addZdemand(1L,new Zdemand()))
                .isInstanceOf(EntityNotFoundException.class)
                .hasMessage("we dont have person %s".formatted(1L));
    }

    @Test
    void  addXdemand(){
        when(personRepository.findById(any())).thenReturn(Optional.of(person));

        MessageResponse messageResponse = demandService.addXdemand(1L, new Xdemand());

        assertThat(messageResponse.getMessage()).isEqualTo("Xdemand %s has been added successfully!".formatted(1L));
    }
    @Test
    void addXdemandNotFoundPerson(){
        when(personRepository.findById(any())).thenReturn(Optional.empty());

        assertThatThrownBy(()->demandService.addXdemand(1L,new Xdemand()))
                .isInstanceOf(EntityNotFoundException.class)
                .hasMessage("we dont have person %s".formatted(1L));
    }
}