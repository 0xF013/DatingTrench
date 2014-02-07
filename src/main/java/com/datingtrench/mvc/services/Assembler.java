package com.datingtrench.mvc.services;

/**
 * Created by elvis on 2/7/14.
 */

import com.datingtrench.mvc.entities.Role;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;


/**
 * Created by elvis on 2/7/14.
 */
@Service("assembler")
public class Assembler {

    @Transactional(readOnly = true)
    User buildUserFromUserEntity(com.datingtrench.mvc.entities.User userEntity) {

        String username = userEntity.getName();
        String password = userEntity.getPassword();
        boolean enabled = userEntity.getIsActive();
        boolean accountNonExpired = userEntity.getIsActive();
        boolean credentialsNonExpired = userEntity.getIsActive();
        boolean accountNonLocked = userEntity.getIsActive();
        Long id = userEntity.getId();

        Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        for (Role role : userEntity.getRoles()) {
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        }

        User user = new User(username, password, enabled,
                accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
        return user;
    }

}