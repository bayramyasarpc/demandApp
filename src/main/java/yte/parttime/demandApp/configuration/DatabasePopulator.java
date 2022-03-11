package yte.parttime.demandApp.configuration;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;
import yte.parttime.demandApp.controller.request.AddPersonRequest;
import yte.parttime.demandApp.controller.request.AuthorityRequest;
import yte.parttime.demandApp.entity.Authority;
import yte.parttime.demandApp.entity.Person;
import yte.parttime.demandApp.login.controller.LoginRequest;
import yte.parttime.demandApp.repository.AuthorityRepository;
import yte.parttime.demandApp.repository.UserRepository;
import yte.parttime.demandApp.entity.Users;

import javax.transaction.Transactional;
import java.util.Set;


@Repository
public class DatabasePopulator {

    private final AuthorityRepository authorityRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public DatabasePopulator(AuthorityRepository authorityRepository, UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.authorityRepository = authorityRepository;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    public void populateDatabase(){

        Authority userAuthority = authorityRepository.save(new Authority(1L, "USER", Set.of()));
        Authority adminAuthority = authorityRepository.save(new Authority(2L, "ADMIN", Set.of()));

        Users users =new Users(1L,"user",passwordEncoder.encode("user"),Set.of(userAuthority),null);
        userRepository.save(users);

        Users admin =new Users(2L,"admin",passwordEncoder.encode("admin"),Set.of(adminAuthority,userAuthority),null);
        userRepository.save(admin);
    }

    @Transactional
    public void giveAuthority(Person person,AuthorityRequest authorityRequest) {
        Authority userAuthority = authorityRepository.save(new Authority(1L, "USER", Set.of()));
        Authority adminAuthority = authorityRepository.save(new Authority(2L, "ADMIN", Set.of()));

        if(authorityRequest.getAuthorityEnum().equals(userAuthority.getAuthority())){
            Users addPerson = new Users(null, person.getFirstName(), passwordEncoder.encode(person.getLastName()), Set.of(userAuthority),null);
            userRepository.save(addPerson);
        }else{
            Users addPerson = new Users(null, person.getFirstName(), passwordEncoder.encode(person.getLastName()), Set.of(adminAuthority),null);
            userRepository.save(addPerson);
        }
    }



}
