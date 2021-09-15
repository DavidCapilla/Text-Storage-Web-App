package com.reflexiones.text.storage.account.registration;

import com.reflexiones.text.storage.user.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/account")
@AllArgsConstructor
public class RegistrationController {

  @Autowired private UserRepository userRepository;

  @PostMapping("/register")
  @ResponseStatus(HttpStatus.CREATED)
  public RegistrationResponseCode createAccount(@RequestBody RegistrationRequest request) {
    // TODO: Implement sign up of the user to the database
    return RegistrationResponseCode.UNDEFINED;
  }
}
