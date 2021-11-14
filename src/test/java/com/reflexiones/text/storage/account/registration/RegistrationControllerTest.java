package com.reflexiones.text.storage.account.registration;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class RegistrationControllerTest {

  private static final String USERNAME = "user";
  private static final String PASSWORD = "password";
  @Mock private RegistrationService registrationService;
  @InjectMocks private RegistrationController testee;

  @Test
  public void createAccount_whenTheUserDoesNotExist_thenUserCreatedResponseCodeIsReturned() {

    when(registrationService.registerUser(any())).thenReturn(RegistrationResponseCode.USER_CREATED);
    RegistrationResponseCode response =
        testee.createAccount(new RegistrationRequest(USERNAME, PASSWORD));
    assertThat(response, is(RegistrationResponseCode.USER_CREATED));
  }

  @Test
  public void createAccount_whenTheUserExists_thenUserAlreadyExistsResponseCodeIsReturned() {

    when(registrationService.registerUser(any())).thenReturn(RegistrationResponseCode.USER_ALREADY_EXIST);
    RegistrationResponseCode response =
        testee.createAccount(new RegistrationRequest(USERNAME, PASSWORD));
    assertThat(response, is(RegistrationResponseCode.USER_ALREADY_EXIST));
  }

  @Test
  public void login_returnsTrue() {

    assertThat(testee.login(), is(true));
  }
}
