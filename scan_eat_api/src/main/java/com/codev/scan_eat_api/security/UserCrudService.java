package com.codev.scan_eat_api.security;

import com.codev.scan_eat_api.entities.User;

import java.util.Optional;

/**
 * SecuredUser security operations like login and logout, and CRUD operations on {@link SecuredUser}.
 *
 * @author jerome
 *
 */
public interface UserCrudService {

    User save(SecuredUser securedUser);

    Optional<User> find(String id);

    Optional<User> findByUsername(String username);
}
