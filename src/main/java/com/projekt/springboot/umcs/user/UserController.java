package com.projekt.springboot.umcs.user;

import com.projekt.springboot.umcs.MyUserDetailsService;
import com.projekt.springboot.umcs.ad.Ad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping(path="api/v1/auth")
public class UserController {
    @Autowired
    private MyUserDetailsService userService;

    @PostMapping("register")
    public void registerUserAccount(@RequestParam(required = true) String username,
                                    @RequestParam(required = true) String password) {
        User registered = userService.registerNewUserAccount(username, password);
    }

    @GetMapping("info")
    public User getUserInfo() {
        MyUserDetails userDetails = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return userService.getUserInfo(userDetails.getId());
    }

}