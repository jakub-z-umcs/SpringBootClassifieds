package com.projekt.springboot.umcs.user;

import com.projekt.springboot.umcs.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping(path="api/v1/auth")
public class UserController {
    @Autowired
    private MyUserDetailsService userService;

    @PostMapping("register")
    public void registerUserAccount(@RequestParam(required = true) String login,
                                    @RequestParam(required = true) String password) {
        User registered = userService.registerNewUserAccount(login, password);
    }
}