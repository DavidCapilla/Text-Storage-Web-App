package com.reflexiones.text.storage.user;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

  public static final String ENCODED_PASSWORD = "theEncodedPassword";
  public static final String USERNAME = "theUsername";
  public static final String PASSWORD = "thePassword";
  @Mock private UserRepository userRepository;
  @Mock private BCryptPasswordEncoder bCryptPasswordEncoder;
  @Captor ArgumentCaptor<User> userArgumentCaptor;
  @InjectMocks private UserService testee;

  @Test
  public void loadUserByUsername_whenTheUserIsInTheRepository_thenUserDetailsAreReturned() {
    User user = getUser();
    when(userRepository.findByUsername(any())).thenReturn(Optional.of(user));

    assertThat(testee.loadUserByUsername(USERNAME), is(user));
  }

  @Test
  public void
      loadUserByUsername_whenThereIsNoSuchUserInTheRepository_thenUsernameNotFoundExceptionIsThrown() {
    when(userRepository.findByUsername(any())).thenReturn(Optional.empty());
    assertThrows(UsernameNotFoundException.class, () -> testee.loadUserByUsername(USERNAME));
  }

  @Test
  public void registerUser_whenTheUserIsInTheRepository_thenReturnsFalse() {

    when(userRepository.findByUsername(any())).thenReturn(Optional.of(new User()));
    assertThat(testee.registerUser(new User()), is(false));
  }

  @Test
  public void registerUser_whenThereIsNoSuchUserInTheRepository_thenTheUserIsSavedAndReturnsTrue() {

    when(userRepository.findByUsername(any())).thenReturn(Optional.empty());
    when(bCryptPasswordEncoder.encode(any())).thenReturn(ENCODED_PASSWORD);

    User user = getUser();
    assertThat(testee.registerUser(user), is(true));

    verify(userRepository, times(1)).save(userArgumentCaptor.capture());
    assertThat(userArgumentCaptor.getValue().getUsername(), is(user.getUsername()));
    assertThat(userArgumentCaptor.getValue().getPassword(), is(ENCODED_PASSWORD));
  }

  private User getUser() {
    return new User(USERNAME, PASSWORD);
  }
}
