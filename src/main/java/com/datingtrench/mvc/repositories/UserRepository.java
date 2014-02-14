package com.datingtrench.mvc.repositories;

/**
 * Created by elvis on 2/6/14.
 */

import com.datingtrench.mvc.base.AbstractRepository;
import com.datingtrench.mvc.models.entities.User;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends AbstractRepository<User> {
    User findOneByName(String name);

    @Query("select u from Users u join u.authenticationAccount a where a.activationCode =?1")
    User findUserByActivationCode(String activationCode);
}