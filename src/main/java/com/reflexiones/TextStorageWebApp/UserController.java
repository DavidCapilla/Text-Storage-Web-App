package com.reflexiones.TextStorageWebApp;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @PostMapping("/signin")
    @ResponseBody
    public SignInResponseCode registerUser(@RequestBody User user) {
        //TODO: Implement sign in of the user to the database
        return SignInResponseCode.UNDEFINED;
    }
}
