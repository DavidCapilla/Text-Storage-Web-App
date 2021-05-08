package com.reflexiones.TextStorageWebApp;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.fail;

public class UserControllerTest {

    private UserController testee;

    @Test
    void registerUser_whenTheUsernameDoesNotExistInTheDatabase_thenTheUserIsAdded() {
       fail();
    }

    @Test
    void registerUser_whenTheUsernameAlreadyExistsInTheDatabase_thenAnErrorIsReturnedAndTheUserIsNotAdded() {
        fail();
    }
}


