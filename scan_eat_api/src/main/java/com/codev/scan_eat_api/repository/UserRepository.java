package com.codev.scan_eat_api.repository;

import com.codev.scan_eat_api.entities.Recipe;
import com.codev.scan_eat_api.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}
