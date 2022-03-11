package yte.parttime.demandApp.login.controller;

import lombok.Getter;
import org.springframework.web.bind.annotation.*;
import yte.parttime.demandApp.login.service.LoginService;

import javax.validation.Valid;

@RestController
@Getter
public class LoginController {

    private final LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping("/login")
    public String login(@Valid @RequestBody LoginRequest loginRequest){
        return loginService.login(loginRequest);
    }

    @GetMapping("/login")
    public  String loginGetRequest(@RequestParam String username,@RequestParam String password){
        return loginService.loginGetRequest(username,password);
    }
}
