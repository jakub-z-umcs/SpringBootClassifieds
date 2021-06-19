package com.projekt.springboot.umcs.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("registration")
    public void registerUserAccount() {
        CustomUser registered = userService.registerNewUserAccount("elo", "320");

        // rest of the implementation
    }
}
