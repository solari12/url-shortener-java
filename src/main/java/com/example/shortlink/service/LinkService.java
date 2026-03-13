package com.example.shortlink.service;

import com.example.shortlink.model.Links;
import com.example.shortlink.repository.LinkRepository;
import com.example.shortlink.utils.Base62;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LinkService {

    @Autowired
    LinkRepository linkRepository;

    public String generateCode(long num) {

        return Base62.encode(num);

    }

    public void increaseClick(Links links){
        links.increaseClick();
        linkRepository.save(links);
    }
}