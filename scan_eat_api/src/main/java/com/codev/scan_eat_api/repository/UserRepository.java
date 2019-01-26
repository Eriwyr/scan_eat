package com.codev.scan_eat_api.repository;


import com.codev.scan_eat_api.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * SecuredUser security operations like login and logout, and CRUD operations on {@link User}.
 *
 * @author jerome
 *
 */

@Repository
public interface UserRepository extends JpaRepository<User, String> {

    //User save(User user);

    //Optional<User> find(String username);

    //Optional<User> findByUsername(String username);
}
