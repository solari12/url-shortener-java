package com.example.shortlink.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.URL;


public class UrlRequest {
    @NotBlank(message = "URL cannot be empty")
    @URL(message = "Invalid URL format")
    @Size(max = 2048)
    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}