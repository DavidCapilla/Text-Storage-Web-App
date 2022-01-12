package com.reflexiones.text.storage.account.registration;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/account")
@AllArgsConstructor
public class RegistrationController {

  private RegistrationService registrationService;

  @PostMapping("/register")
  // TODO: Should we manage this annotation to not return created all the time?
  @ResponseStatus(HttpStatus.CREATED)
  public RegistrationResponseCode createAccount(@RequestBody RegistrationRequest request) {
    return registrationService.registerUser(request);
  }

  @GetMapping("/login")
  public boolean login() {
    // Currently it will only be used to ensure that the call is done with a registered user.
    return true;
  }
}
