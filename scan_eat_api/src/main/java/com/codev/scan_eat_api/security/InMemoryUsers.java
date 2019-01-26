package com.codev.scan_eat_api.security;

import com.codev.scan_eat_api.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

import static java.util.Optional.ofNullable;

@Service
final class InMemoryUsers implements UserCrudService {

    Map<String, SecuredUser> users = new HashMap<>();
    UserRepository userRepo;

    @Override
    public SecuredUser save(final SecuredUser securedUser) {
        userRepo.findById(securedUser.getUsername());
        return users.put(securedUser.getId(), securedUser);

    }

    @Override
    public Optional<SecuredUser> find(final String id) {
        return ofNullable(users.get(id));
    }

    @Override
    public Optional<SecuredUser> findByUsername(final String username) {
        return users
                .values()
                .stream()
                .filter(u -> Objects.equals(username, u.getUsername()))
                .findFirst();
    }
}

