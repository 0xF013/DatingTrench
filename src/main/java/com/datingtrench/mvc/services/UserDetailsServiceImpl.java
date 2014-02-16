package com.datingtrench.mvc.services;

import com.datingtrench.mvc.models.entities.AuthenticationAccount;
import com.datingtrench.mvc.models.entities.User;
import com.datingtrench.mvc.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by elvis on 2/16/14.
 */

@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {

        UserDetails userDetails = null;
        User userEntity = userRepository.findActiveUserByEmail(username.toLowerCase());
        if (userEntity == null)
            throw new UsernameNotFoundException("user not found");

        return buildUserFromUserEntity(userEntity.getAuthenticationAccount());
    }

    @Transactional(readOnly = true)
    private org.springframework.security.core.userdetails.User buildUserFromUserEntity(AuthenticationAccount authenticationAccount) {
        com.datingtrench.mvc.models.entities.User userEntity = authenticationAccount.getUser();
        String username = userEntity.getEmail();
        String password = authenticationAccount.getPassword();
        boolean enabled = authenticationAccount.getIsActive();
        boolean accountNonExpired = authenticationAccount.getIsActive();
        boolean credentialsNonExpired = authenticationAccount.getIsActive();
        boolean accountNonLocked = authenticationAccount.getIsActive();

        Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        authorities.add(new SimpleGrantedAuthority("ROLE_USER"));

        return new org.springframework.security.core.userdetails.User(username, password, enabled,
                accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
    }
}
