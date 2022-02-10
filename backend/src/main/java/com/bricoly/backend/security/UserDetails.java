package com.bricoly.backend.security;

import com.bricoly.backend.domain.User;
import com.bricoly.backend.dto.UserDTO;
import com.bricoly.backend.mapper.UserMapper;
import com.bricoly.backend.service.UserService;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class UserDetails implements UserDetailsService {

    private final UserService userService;
    private final UserMapper userMapper;

    public UserDetails(UserService userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @Override
    public org.springframework.security.core.userdetails.UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<User> user = userService.findByEmail(email);
        if(user.isPresent()){
            UserDTO userDTO = userMapper.asDTO(user.get()) ;
            return new org.springframework.security.core.userdetails.User(userDTO.getEmail(), userDTO.getPassword(), new ArrayList<>());
        } else {
            throw new UsernameNotFoundException("User with email " + email + " not found...");
        }
    }
}
