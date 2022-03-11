package yte.parttime.demandApp.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import yte.parttime.demandApp.configuration.DatabasePopulator;
import yte.parttime.demandApp.controller.request.AuthorityRequest;
import yte.parttime.demandApp.entity.Authority;
import yte.parttime.demandApp.entity.Person;
import yte.parttime.demandApp.entity.Users;
import yte.parttime.demandApp.message.MessageResponse;
import yte.parttime.demandApp.message.MessageType;
import yte.parttime.demandApp.repository.PersonRepository;
import yte.parttime.demandApp.repository.UserRepository;


import javax.transaction.Transactional;
import java.util.Set;

@Service
public class PersonService {

    private final PersonRepository personRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;


    public PersonService(PersonRepository personRepository, UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.personRepository = personRepository;
        this.userRepository = userRepository;


        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    public MessageResponse addPerson(Person person,String authority){
        personRepository.save(person);
        person.addUser(person);

        if(authority.equals("USER")) {
            Authority authority1 = new Authority(1L, authority, Set.of());
            Users users = new Users(null,person.getFirstName(),
                                                passwordEncoder.encode(person.getLastName()), Set.of(authority1),person);
            userRepository.save(users);
        }else if(authority.equals("ADMIN")){
            Authority authority1 = new Authority(2L, authority, Set.of());
            Users users = new Users(null, person.getFirstName(), person.getLastName(), Set.of(authority1),person);
            userRepository.save(users);
        }


        return new MessageResponse("person saved successfully!", MessageType.SUCCESS);
    }

//    @Transactional
//    public String giveAuthority(Long id,AuthorityRequest authorityRequest) {
//            Person person=personRepository.findByFirstnameAndLastname(authorityRequest.getFirstName(), authorityRequest.getLastName());
//            if(person!=null){
//                databasePopulator.giveAuthority(person,authorityRequest);
//                return "authority verildi";
//            }else{
//                return "person not found";
//            }
//    }
}
