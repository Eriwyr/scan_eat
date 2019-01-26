package com.codev.scan_eat_api.security;

import com.codev.scan_eat_api.entities.User;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;
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
    UserCrudService users;

    @Override
    public Optional<String> login(final String username, final String password) {
        final String uuid = UUID.randomUUID().toString();
        Optional<User> userTmp = users.findByUsername(username);
        final SecuredUser securedUser = SecuredUser
                .builder()
                .id(uuid)
                .username(username)
                .password(password)
                .firstName(userTmp.get().getFirstName())
                .build();

        users.save(securedUser);
        return Optional.of(uuid);
    }

    @Override
    public Optional<User> findByToken(final String token) {
        return users.find(token);
    }

    @Override
    public void logout(final User user) {

    }
}
