package com.reflexiones.text.storage.user;

import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService implements UserDetailsService {

  private static final String USER_NOT_FOUND_MESSAGE = "user with username %s not found";

  private final UserRepository userRepository;
  private final BCryptPasswordEncoder bCryptPasswordEncoder;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

    return userRepository
        .findByUsername(username)
        .orElseThrow(
            () -> new UsernameNotFoundException(String.format(USER_NOT_FOUND_MESSAGE, username)));
  }

  public boolean registerUser(User user) {

    if (userRepository.findByUsername(user.getUsername()).isPresent()) {
      return false;
    }

    User userWithEncodedPassword = createUserWithEncodedPassword(user);
    userRepository.save(userWithEncodedPassword);

    return true;
  }

  private User createUserWithEncodedPassword(User user) {
    return new User(user.getUsername(), bCryptPasswordEncoder.encode(user.getPassword()));
  }
}
