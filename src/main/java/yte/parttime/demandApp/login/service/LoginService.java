package yte.parttime.demandApp.login.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import yte.parttime.demandApp.login.controller.LoginRequest;
import yte.parttime.demandApp.login.util.JwtUtil;

@Service
public class LoginService {

    @Value("${security.jtw.secret-key}")
    private String secretKey;

    private final AuthenticationManager authenticationManager;

    public LoginService(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    public String login(LoginRequest loginRequest){
        var token = new UsernamePasswordAuthenticationToken(loginRequest.getUsername(),loginRequest.getPassword());

        Authentication authenticationToken = authenticationManager.authenticate(token);

        authenticationToken.getPrincipal();
        return JwtUtil.generateToken(authenticationToken,secretKey);
    }




    public String loginGetRequest(String username, String password) {
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(username, password);

        Authentication authenticationToken = authenticationManager.authenticate(token);
        authenticationToken.getPrincipal();
        return JwtUtil.generateToken(authenticationToken,secretKey);
    }
}
