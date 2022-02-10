package com.bricoly.backend.controller.impl;

import com.bricoly.backend.controller.AuthController;
import com.bricoly.backend.domain.User;
import com.bricoly.backend.dto.UserDTO;
import com.bricoly.backend.mapper.UserMapper;
import com.bricoly.backend.security.JwtTokenUtil;
import com.bricoly.backend.security.UserDetails;
import com.bricoly.backend.service.UserService;
import lombok.Data;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class AuthControllerImpl implements AuthController {

    private final JwtTokenUtil jwtTokenUtil;
    private final UserDetails userDetails;
    private final UserService userService;
    private final UserMapper userMapper;

    public AuthControllerImpl(JwtTokenUtil jwtTokenUtil, UserDetails userDetails, UserService userService, UserMapper userMapper) {
        this.jwtTokenUtil = jwtTokenUtil;
        this.userDetails = userDetails;
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @Data
    public static class AuthRequest {
        private String email;
        private String password;
    }

    @PostMapping("/login")
    public ResponseEntity<UserDTO> login(@RequestBody AuthRequest request) {
        Optional<User> user = userService.checkCredentials(request.getEmail(), request.getPassword());
        return user.map(value -> ResponseEntity.ok()
                .header(
                        HttpHeaders.AUTHORIZATION,
                        jwtTokenUtil.generateToken(userDetails.loadUserByUsername(value.getEmail()))
                )
                .body(userMapper.asDTO(value))).orElseGet(() -> ResponseEntity.status(HttpStatus.UNAUTHORIZED).build());
    }
}