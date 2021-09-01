package com.reflexiones.textstoragewebapp.user;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @PostMapping("/create_account")
    @ResponseBody
    public SignInResponseCode createAccount(@RequestBody User user) {
        //TODO: Implement sign in of the user to the database
        return SignInResponseCode.UNDEFINED;
    }
}
