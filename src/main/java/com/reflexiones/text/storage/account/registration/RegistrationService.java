package com.reflexiones.text.storage.account.registration;

import com.reflexiones.text.storage.user.User;
import com.reflexiones.text.storage.user.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RegistrationService {

  private final UserService userService;

  public RegistrationResponseCode registerUser(RegistrationRequest request) {

    return userService.registerUser(new User(request.getUsername(), request.getPassword()))
        ? RegistrationResponseCode.USER_CREATED
        : RegistrationResponseCode.USER_ALREADY_EXIST;
  }
}
