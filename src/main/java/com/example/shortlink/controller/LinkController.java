package com.example.shortlink.controller;

import com.example.shortlink.model.Links;
import com.example.shortlink.model.UrlRequest;
import com.example.shortlink.model.UrlResponse;
import com.example.shortlink.repository.LinkRepository;
import com.example.shortlink.service.LinkService;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@RestController
public class LinkController {

    @Autowired
    private LinkRepository repository;

    @Autowired
    private LinkService service;

    @PostMapping("/shorten")
    public ResponseEntity<UrlResponse> shorten(@Valid @RequestBody UrlRequest request) {

        String url = request.getUrl();

        if(!url.startsWith("http://") && !url.startsWith("https://")){
            url = "https://" + url;
        }

        String code = service.generateCode();

        Links link = new Links();
        link.setOriginalUrl(url);
        link.setShortCode(code);

        UrlResponse urlResponse = new UrlResponse("http://localhost:8080/" + code, code);

        repository.save(link);

        return ResponseEntity.ok(urlResponse);
    }

    @GetMapping("/{code}")
    public RedirectView redirect(@PathVariable String code) {

        Links link = repository.findByShortCode(code);

        if (link == null) {
            throw new RuntimeException("Short link not found");
        }

        return new RedirectView(link.getOriginalUrl());
    }
}