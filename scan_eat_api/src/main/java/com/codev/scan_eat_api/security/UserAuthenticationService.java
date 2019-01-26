package com.codev.scan_eat_api.security;


import com.codev.scan_eat_api.entities.User;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

public interface UserAuthenticationService {

    /**
     * Logs in with the given {@code username} and {@code password}.
     *
     * @param username
     * @param password
     * @return an {@link Optional} of a user when login succeeds
     */
    Optional<String> login(String username, String password, PasswordEncoder passwordEncoder);

    /**
     * Finds a user by its dao-key.
     *
     * @param token user dao key
     * @return
     */
    Optional<User> findByToken(String token);

    /**
     * Logs out the given input {@code securedUser}.
     *
     * @param user the securedUser to logout
     */
    void logout(User user);
}
