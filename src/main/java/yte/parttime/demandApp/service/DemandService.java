package yte.parttime.demandApp.service;

import org.springframework.stereotype.Service;
import yte.parttime.demandApp.entity.Demand;
import yte.parttime.demandApp.entity.Person;
import yte.parttime.demandApp.entity.demands.Xdemand;
import yte.parttime.demandApp.entity.demands.Ydemand;
import yte.parttime.demandApp.entity.demands.Zdemand;
import yte.parttime.demandApp.message.MessageResponse;
import yte.parttime.demandApp.message.MessageType;
import yte.parttime.demandApp.repository.DemandRepository;
import yte.parttime.demandApp.repository.PersonRepository;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

@Service
public class DemandService {

    private final DemandRepository demandRepository;
    private final PersonRepository personRepository;


    public DemandService(DemandRepository demandRepository, PersonRepository personRepository) {
        this.demandRepository = demandRepository;
        this.personRepository = personRepository;
    }

    @Transactional
    public MessageResponse addYdemand(Long id, Ydemand ydemand) {
        Person person=personRepository.findById(id).
                orElseThrow(()->new EntityNotFoundException("we dont have person %s".formatted(id)));
        person.addYdemand(ydemand);
        return  new MessageResponse("Ydemand %s has been added successfully!".formatted(id), MessageType.SUCCESS);
    }

    @Transactional
    public MessageResponse addZdemand(Long id, Zdemand zdemand) {
        Person person=personRepository.findById(id).
                orElseThrow(()->new EntityNotFoundException("we dont have person %s".formatted(id)));
        person.addZdemand(zdemand);
        return  new MessageResponse("Zdemand %s has been added successfully!".formatted(id), MessageType.SUCCESS);
    }

    @Transactional
    public MessageResponse addXdemand(Long id, Xdemand xdemand) {
        Person person = personRepository.findById(id).
                orElseThrow(()->new EntityNotFoundException("we dont have person %s".formatted(id)));
        person.addXdemand(xdemand);
        return  new MessageResponse("Xdemand %s has been added successfully!".formatted(id), MessageType.SUCCESS);
    }
}
