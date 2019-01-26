package com.codev.scan_eat_api.security;

import java.util.Optional;

/**
 * SecuredUser security operations like login and logout, and CRUD operations on {@link SecuredUser}.
 *
 * @author jerome
 *
 */
public interface UserCrudService {

    SecuredUser save(SecuredUser securedUser);

    Optional<SecuredUser> find(String id);

    Optional<SecuredUser> findByUsername(String username);
}
