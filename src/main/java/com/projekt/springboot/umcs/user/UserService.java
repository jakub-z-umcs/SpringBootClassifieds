package com.projekt.springboot.umcs.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@Service
@Transactional
public class UserService {
    @Autowired
    private UserRepository repository;

    public CustomUser registerNewUserAccount(String login, String password) {
        List<GrantedAuthority> permissions = new ArrayList<GrantedAuthority>();
        CustomUser user = new CustomUser("test", "12345678", permissions);

        return repository.save(user);
    }
}