package com.codev.scan_eat_api.security;

import com.codev.scan_eat_api.entities.User;
import com.codev.scan_eat_api.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

import static lombok.AccessLevel.PACKAGE;
import static lombok.AccessLevel.PRIVATE;

@Service
@AllArgsConstructor(access = PACKAGE)
@FieldDefaults(level = PRIVATE, makeFinal = true)
final class UUIDAuthenticationService implements UserAuthenticationService {
    @NonNull
    UserRepository users;

    @Override
    public Optional<String> login(final String username, final String password, PasswordEncoder passwordEncoder) {
        final String uuid = UUID.randomUUID().toString();
        Optional<User> user = users.findById(username);

        if(user.isPresent() && passwordEncoder.matches(password, user.get().getPassword())) {
            user.get().setToken(uuid);
            TokenStore.saveToken(uuid, username);
            return Optional.of(uuid);
        } else {
            return Optional.empty();
        }
    }

    @Override
    public Optional<User> findByToken(final String token) {
        Optional<String> username = TokenStore.getUsernameByToken(token);
        return username.flatMap(users::findById);
    }

    @Override
    public void logout(final User user) {
        TokenStore.deleteToken(user.getToken());
    }
}
