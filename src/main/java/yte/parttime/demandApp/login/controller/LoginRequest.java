package yte.parttime.demandApp.login.controller;

import lombok.Getter;

import javax.validation.constraints.NotEmpty;

@Getter
public class LoginRequest {

    @NotEmpty
    private String username;

    @NotEmpty
    private String password;
}
