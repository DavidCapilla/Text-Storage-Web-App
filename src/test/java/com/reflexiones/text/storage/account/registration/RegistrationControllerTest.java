package com.reflexiones.text.storage.account.registration;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class RegistrationControllerTest {

    @InjectMocks private RegistrationController testee;

    @Test
    public void createdAccount_returnsUndefinedResponse() {
        RegistrationResponseCode response = testee.createAccount(new RegistrationRequest("user", "password"));
        assertThat(response, is(RegistrationResponseCode.UNDEFINED));
    }

}