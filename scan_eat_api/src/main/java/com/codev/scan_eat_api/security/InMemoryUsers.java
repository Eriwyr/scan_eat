package com.codev.scan_eat_api.security;

import com.codev.scan_eat_api.entities.User;
import com.codev.scan_eat_api.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

import static java.util.Optional.ofNullable;

@Service
final class InMemoryUsers implements UserCrudService {

    Map<String, User> users = new HashMap<>();
    UserRepository userRepo;

    @Override
    public User save(final SecuredUser securedUser) {
        User user = userRepo.findById(securedUser.getUsername()).get();
        user.setSecuredUser(securedUser);
        return users.put(securedUser.getId(), user);

    }

    @Override
    public Optional<User> find(final String id) {
        return ofNullable(users.get(id));
    }

    @Override
    public Optional<User> findByUsername(final String username) {
        return users
                .values()
                .stream()
                .filter(u -> u.getUsername().equals(username))
                .findFirst();
    }
}

