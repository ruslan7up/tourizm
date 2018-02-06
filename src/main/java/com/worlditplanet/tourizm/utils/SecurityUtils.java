package com.worlditplanet.tourizm.utils;

import org.springframework.security.authentication.encoding.Md5PasswordEncoder;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by Admin on 26.01.2018.
 */
public class SecurityUtils {
    public static String encodePassword(String password) {
        return new Md5PasswordEncoder().encodePassword(password, null);
    }
}
