package com.projekt.springboot.umcs.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping(path="api/v1/auth")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("register")
    public void registerUserAccount() {
        CustomUser registered = userService.registerNewUserAccount("elo", "320");

        // rest of the implementation
    }
}
