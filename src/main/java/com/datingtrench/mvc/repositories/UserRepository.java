package com.datingtrench.mvc.repositories;

/**
 * Created by elvis on 2/6/14.
 */

import com.datingtrench.mvc.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}