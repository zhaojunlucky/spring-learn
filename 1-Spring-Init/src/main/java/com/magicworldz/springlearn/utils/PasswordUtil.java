package com.magicworldz.springlearn.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordUtil {
    private PasswordUtil () {

    }

    public static String encodePassword(CharSequence plainPassword) {
        var passEncoder = new BCryptPasswordEncoder();
        return passEncoder.encode(plainPassword);
    }
}