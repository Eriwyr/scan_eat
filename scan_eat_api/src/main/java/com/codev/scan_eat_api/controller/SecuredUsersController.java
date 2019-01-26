package com.codev.scan_eat_api.controller;

import com.codev.scan_eat_api.security.SecuredUser;
import com.codev.scan_eat_api.security.UserAuthenticationService;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static lombok.AccessLevel.PACKAGE;
import static lombok.AccessLevel.PRIVATE;

@RestController
@RequestMapping("/users")
@FieldDefaults(level = PRIVATE, makeFinal = true)
@AllArgsConstructor(access = PACKAGE)
final class SecuredUsersController {
    @NonNull
    UserAuthenticationService authentication;

    @GetMapping("/current")
    SecuredUser getCurrent(@AuthenticationPrincipal final SecuredUser securedUser) {
        return securedUser;
    }

    @GetMapping("/logout")
    boolean logout(@AuthenticationPrincipal final SecuredUser securedUser) {
        authentication.logout(securedUser);
        return true;
    }
}