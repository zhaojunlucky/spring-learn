package com.magicworldz.springlearn.security;

import com.magicworldz.springlearn.security.entity.User;
import com.magicworldz.springlearn.security.jpa.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/security")
public class SecurityController {
    @Autowired
    UserRepository userRepository;

    @RequestMapping(value = "user/{username}", method = RequestMethod.GET)
    public User getUser(@PathVariable("username") String username) {
        var user = userRepository.findUserByName(username);
        return user;
    }
}
