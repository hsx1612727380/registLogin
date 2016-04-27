package com.hsx.util;

import java.security.MessageDigest;

import sun.misc.BASE64Encoder;

public class MD5Util {

	@SuppressWarnings("restriction")
    public static String encode(String string) {
        String result = null;
        try {
            MessageDigest md = MessageDigest.getInstance("md5");
            byte[] b = md.digest(string.getBytes());
            BASE64Encoder encoder = new BASE64Encoder();
            result = encoder.encode(b);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return result;
    }
	
}
