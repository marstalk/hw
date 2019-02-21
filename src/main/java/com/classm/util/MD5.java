package com.classm.util;


import lombok.extern.slf4j.Slf4j;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Slf4j
public class MD5 {

    public static String encrypt(String plainString) {
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            md5.update(plainString.getBytes());
            return md5.digest().toString();
        } catch (NoSuchAlgorithmException e) {
            log.error(e.getMessage(), e);
        }
        return null;
    }

}
