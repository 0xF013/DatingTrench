package com.datingtrench.mvc.repositories;

/**
 * Created by elvis on 2/6/14.
 */

import com.datingtrench.mvc.base.AbstractRepository;
import com.datingtrench.mvc.entities.User;

public interface UserRepository extends AbstractRepository<User> {
    User findOneByName(String name);
}