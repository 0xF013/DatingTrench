package com.datingtrench.mvc.services;

import com.datingtrench.mvc.entities.User;
import com.datingtrench.mvc.entities.auth.AuthenticationAccount;
import com.datingtrench.mvc.entities.auth.Role;
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

@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {

        UserDetails userDetails = null;
        User userEntity = userRepository.findOneByName(username.toLowerCase());
        if (userEntity == null)
            throw new UsernameNotFoundException("user not found");

        return buildUserFromUserEntity(userEntity.getAuthenticationAccount());
    }

    @Transactional(readOnly = true)
    private org.springframework.security.core.userdetails.User buildUserFromUserEntity(AuthenticationAccount authenticationAccount) {
        com.datingtrench.mvc.entities.User userEntity = authenticationAccount.getUser();
        String username = userEntity.getEmail();
        String password = authenticationAccount.getPassword();
        boolean enabled = authenticationAccount.getIsActive();
        boolean accountNonExpired = authenticationAccount.getIsActive();
        boolean credentialsNonExpired = authenticationAccount.getIsActive();
        boolean accountNonLocked = authenticationAccount.getIsActive();
        Long id = userEntity.getId();

        Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        for (Role role : authenticationAccount.getRoles()) {
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        }

        org.springframework.security.core.userdetails.User user = new org.springframework.security.core.userdetails.User(username, password, enabled,
                accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
        return user;
    }

}