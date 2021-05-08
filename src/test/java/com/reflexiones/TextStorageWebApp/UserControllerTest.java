package com.reflexiones.TextStorageWebApp;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.fail;

public class UserControllerTest {

    private UserController testee;

    @Test
    void createAccount_whenTheUsernameDoesNotExistInTheDatabase_thenTheUserIsAdded() {
       fail();
    }

    @Test
    void createAccount_whenTheUsernameAlreadyExistsInTheDatabase_thenAnErrorIsReturnedAndTheUserIsNotAdded() {
        fail();
    }
}


