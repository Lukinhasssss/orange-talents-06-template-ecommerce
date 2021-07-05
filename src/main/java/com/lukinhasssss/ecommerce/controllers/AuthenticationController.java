package com.lukinhasssss.ecommerce.controllers;

import com.lukinhasssss.ecommerce.config.authentication.TokenService;
import com.lukinhasssss.ecommerce.dto.request.LoginRequest;
import com.lukinhasssss.ecommerce.dto.response.TokenResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authManager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity<TokenResponse> authenticate(@RequestBody @Valid LoginRequest request){
        UsernamePasswordAuthenticationToken loginData = request.convert();

        try {
//            System.out.println(request.getLogin());
//            System.out.println(request.getPassword());
            Authentication authentication =  authManager.authenticate(loginData);
            String token = tokenService.generateToken(authentication);
            return ResponseEntity.ok(new TokenResponse(token, "Bearer"));
        }
        catch(AuthenticationException e) {
            return ResponseEntity.badRequest().build();
        }
    }

}
