package com.quizz.evaluacion.service;

import java.security.GeneralSecurityException;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.quizz.evaluacion.model.User;
import com.quizz.evaluacion.model.UserDto;

public interface UserService extends UserDetailsService {
  User findByUsername(String username);
  User saveUser(UserDto userDto) throws GeneralSecurityException;
}
