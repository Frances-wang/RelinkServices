package com.frances.relink.controllers;

import com.frances.relink.exception.ShortenLinkExistsException;
import com.frances.relink.models.Url;
import com.frances.relink.service.UrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/urls")
public class UrlController {
    private final UrlService urlService;

    @Autowired
    public UrlController(UrlService urlService) {
        this.urlService = urlService;
    }

    // short to long
    @GetMapping("/short")
    public Url getUrl(String shortUrl) {
        return urlService.decodeUrl(shortUrl);
    }

    // long to short
    @PostMapping("/long")
    public Url saveUrl(Url longUrl) {
        return urlService.encodeUrl(longUrl);
    }

    @PostMapping("/custom")
    public Url saveUrl(Url url, String key) {
        try {
            return urlService.saveUrl(url, key);
        } catch (ShortenLinkExistsException e) {
            System.out.println("The custom link is already used, please pick another one.");
        }
        return url;
    }
}
