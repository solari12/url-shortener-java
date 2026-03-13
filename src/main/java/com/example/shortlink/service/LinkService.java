package com.example.shortlink.service;

import com.example.shortlink.utils.Base62;
import org.springframework.stereotype.Service;

@Service
public class LinkService {

    public String generateCode(long num) {

        return Base62.encode(num);

    }
}