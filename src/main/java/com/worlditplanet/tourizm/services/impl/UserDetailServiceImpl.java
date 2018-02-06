package com.worlditplanet.tourizm.services.impl;

import com.worlditplanet.tourizm.dao.UserRepository;
import com.worlditplanet.tourizm.domain.entity.Role;
import com.worlditplanet.tourizm.domain.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin on 07.01.2018.
 */
@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userRepository.getByLogin(s);

        String username = user.getLogin();
        String password = user.getPassword();
        List<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();
        for (Role role:user.getRoles()) {
            authorities.add(new SimpleGrantedAuthority(role.getRoleName().name()));
        }
        return new org.springframework.security.core.userdetails.User(username, password, authorities);
    }
}
