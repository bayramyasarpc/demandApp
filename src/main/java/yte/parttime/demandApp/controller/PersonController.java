package yte.parttime.demandApp.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import yte.parttime.demandApp.configuration.DatabasePopulator;
import yte.parttime.demandApp.controller.request.AddPersonRequest;
import yte.parttime.demandApp.controller.request.AuthorityRequest;
import yte.parttime.demandApp.entity.Person;
import yte.parttime.demandApp.message.MessageResponse;
import yte.parttime.demandApp.service.DemandHistoryService;
import yte.parttime.demandApp.service.PersonService;

import javax.validation.Valid;

@RestController
public class PersonController{

    private final PersonService personService;
    private final DemandHistoryService demandHistoryService;
    private final DatabasePopulator databasePopulator;

    public PersonController(PersonService personService, DemandHistoryService demandHistoryService, DatabasePopulator databasePopulator) {
        this.personService = personService;
        this.demandHistoryService = demandHistoryService;
        this.databasePopulator = databasePopulator;
    }


    @GetMapping("/hello")
    @PreAuthorize("hasAnyAuthority('USER','ADMIN')")
    public String message(){
        return "hello";
    }

    @GetMapping("/getSecurityContext")
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public String context(){
        SecurityContext context = SecurityContextHolder.getContext();
        Authentication authentication= context.getAuthentication();
        UserDetails userDetails =(UserDetails) authentication.getPrincipal();
        System.out.println(userDetails.getUsername());
        System.out.println(userDetails.getPassword());
        return "fff";
    }

    @PostMapping("/kisi-kayit/{authority}")
    @PreAuthorize("hasAnyAuthority('USER','ADMIN')")
    public MessageResponse addPerson(@Valid @PathVariable String authority, @RequestBody AddPersonRequest addPersonRequest){
        Person person = addPersonRequest.toEntity();
        return personService.addPerson(person,authority);
    }

//    @PostMapping("/{id}/authority-verme")
//    @PreAuthorize("hasAuthority('ADMIN')")
//    public String giveAuthority(@PathVariable Long id,@RequestBody AuthorityRequest authorityRequest){
//        return personService.giveAuthority(id,authorityRequest);
//    }

}

