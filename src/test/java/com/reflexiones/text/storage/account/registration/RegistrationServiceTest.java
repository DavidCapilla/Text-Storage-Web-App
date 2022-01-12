package com.reflexiones.text.storage.account.registration;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import com.reflexiones.text.storage.user.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class RegistrationServiceTest {

  private static final String USERNAME = "user";
  private static final String PASSWORD = "password";
  @Mock UserService userService;
  @InjectMocks RegistrationService testee;

  @Test
  public void
      registerUser_whenTheUserIsSuccessfullyCreated_thenUserCreatedResponseCodeIsReturned() {

    when(userService.registerUser(any())).thenReturn(true);
    RegistrationResponseCode response =
        testee.registerUser(new RegistrationRequest(USERNAME, PASSWORD));
    assertThat(response, is(RegistrationResponseCode.USER_CREATED));
  }

  @Test
  public void
      registerUser_whenTheUserCannotBeCreated_thenUserAlreadyExistsResponseCodeIsReturned() {

    when(userService.registerUser(any())).thenReturn(false);
    RegistrationResponseCode response =
        testee.registerUser(new RegistrationRequest(USERNAME, PASSWORD));
    assertThat(response, is(RegistrationResponseCode.USER_ALREADY_EXISTS));
  }
}
