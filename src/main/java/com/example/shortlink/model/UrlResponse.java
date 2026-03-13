package com.example.shortlink.model;

public class UrlResponse {

    private String shortUrl;
    private String code;

    public UrlResponse(String shortUrl, String code) {
        this.shortUrl = shortUrl;
        this.code = code;
    }

    public String getShortUrl() {
        return shortUrl;
    }

    public String getCode() {
        return code;
    }
}
