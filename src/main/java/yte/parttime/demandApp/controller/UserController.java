package yte.parttime.demandApp.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @GetMapping("/user")
    @PreAuthorize("hasAnyAuthority('USER','ADMIN')")
    public String user(){
        return "I am user";
    }


    @GetMapping("/admin")
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public String admin(){
        return "I am admin";
    }
}
