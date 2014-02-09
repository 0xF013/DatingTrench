package com.datingtrench.mvc.services;

import com.datingtrench.mvc.base.AbstractService;
import com.datingtrench.mvc.entities.User;
import com.datingtrench.mvc.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by elvis on 2/9/14.
 */

@Service
public class UserService extends AbstractService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }


}
