package com.quizz.evaluacion.service;

import java.security.GeneralSecurityException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.quizz.evaluacion.model.User;
import com.quizz.evaluacion.model.UserDto;
import com.quizz.evaluacion.repository.UserRepository;
import com.quizz.evaluacion.util.EncryptionUtil;

@Service
public class UserServiceImpl implements UserService {

  @Autowired UserRepository userRepository;

  @Autowired EncryptionUtil encryptionUtil;

  @Override
  public User findByUsername(String username) {
    return userRepository.findByUsername(username);
  }

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    User user = userRepository.findByUsername(username);
    if (user == null) {
      throw new UsernameNotFoundException("User " + username + " was not found in the database");
    }
    return user;
  }

  @Override
  public User saveUser(UserDto userDto) throws GeneralSecurityException {
    User user = new User();
    user.setName(userDto.getName());
    user.setUsername(userDto.getUsername());
    user.setPassword(encryptionUtil.encrypt(userDto.getPassword()));
    user.setAdmin(false);
    user.setLocked(false);
    userRepository.saveAndFlush(user);
    return user;
  }
}
