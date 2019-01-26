package com.codev.scan_eat_api.controller;

import com.codev.scan_eat_api.entities.User;
import com.codev.scan_eat_api.security.UserAuthenticationService;
import com.codev.scan_eat_api.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static lombok.AccessLevel.PACKAGE;
import static lombok.AccessLevel.PRIVATE;

@RestController
@RequestMapping("/public/users")
@FieldDefaults(level = PRIVATE, makeFinal = true)
@AllArgsConstructor(access = PACKAGE)
final class PublicUsersController {
    @NonNull
    UserAuthenticationService authentication;
    @NonNull
    UserRepository users;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/register")
    ResponseEntity<String> register(
            @RequestParam("username") final String username,
            @RequestParam("password") final String password) {
        if(users.findById(username).isPresent()) {
            //return ResponseEntity.status(401).body("Username already exists");
        }
        User user = new User();
        user.setUsername(username);
        user.setPassword(passwordEncoder.encode(password));
        user.setFirstName("lol");
        user.setLastName("lollol");

        users.save(user);
        return ResponseEntity.accepted().body(login(username, password));
    }

    @PostMapping("/login")
    String login(
            @RequestParam("username") final String username,
            @RequestParam("password") final String password) {
        return authentication
                .login(username, password, passwordEncoder)
                .orElseThrow(() -> new RuntimeException("invalid login and/or password"));
    }
}
