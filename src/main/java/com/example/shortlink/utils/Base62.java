package com.example.shortlink.utils;

import org.springframework.stereotype.Component;

@Component
public class Base62 {
    private static final String BASE62 = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public static String encode(long num) {
        StringBuilder sb = new StringBuilder();

        while (num > 0) {
            int remainder = (int) (num % 62);
            sb.append(BASE62.charAt(remainder));
            num = num / 62;
        }

        return sb.reverse().toString();
    }
}
