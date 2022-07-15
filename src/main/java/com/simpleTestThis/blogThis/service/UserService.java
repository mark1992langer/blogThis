package com.simpleTestThis.blogThis.service;

import com.simpleTestThis.blogThis.dto.UserRegistrationDto;
import com.simpleTestThis.blogThis.models.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {
    User save(UserRegistrationDto registrationDto);
}
