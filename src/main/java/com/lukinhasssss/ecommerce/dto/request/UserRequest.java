package com.lukinhasssss.ecommerce.dto.request;

import com.lukinhasssss.ecommerce.config.validation.UniqueValue;
import com.lukinhasssss.ecommerce.entities.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.validation.constraints.*;

public class UserRequest {

    @Email @NotEmpty @NotBlank
    @UniqueValue(domainClass = User.class, fieldName = "login", message = "Email já cadastrado")
    private String login;

    @NotEmpty @NotBlank @Size(min = 6)
    private String password;

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public User convertToEntity(BCryptPasswordEncoder passwordEncoder) {
        return new User(login, passwordEncoder.encode(password));
    }

}
