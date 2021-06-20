package com.projekt.springboot.umcs.user;

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
    private UserService userService;

    @Autowired
    private SecurityService securityService;

    @PostMapping("register")
    public void registerUserAccount(@RequestParam(required = true) String login,
                                    @RequestParam(required = true) String password) {
        CustomUser registered = userService.registerNewUserAccount(login, password);

        // rest of the implementation
    }
}
