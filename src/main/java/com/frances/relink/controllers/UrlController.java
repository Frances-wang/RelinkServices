package com.frances.relink.controllers;

import com.frances.relink.exception.InvalidUrlException;
import com.frances.relink.exception.LongUrlDoesNotExistsException;
import com.frances.relink.exception.ShortenLinkExistsException;
import com.frances.relink.models.Url;
import com.frances.relink.service.UrlService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.io.IOException;

@RestController
@RequestMapping("/re.link")
public class UrlController {
    private final UrlService urlService;

    @Autowired
    public UrlController(UrlService urlService) {
        this.urlService = urlService;
    }

    // redirect
    @GetMapping("/{shortUrlKey}")
    public void redirectUrl(HttpServletResponse response, @PathVariable String shortUrlKey) {
        String[] parts = shortUrlKey.split("/");
        String key = parts[parts.length-1];
        try {
            Url url = urlService.decodeUrl(key);
            response.sendRedirect(url.getLongUrl());
        } catch (LongUrlDoesNotExistsException e) {
            System.out.println("there is no such short url");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // long to short
    @PostMapping("/longUrl")
    public Url saveUrl(@RequestBody Url longUrl, @RequestParam(name="key", required = false) String key) throws ShortenLinkExistsException, InvalidUrlException {
        if (key != null) {
            return urlService.saveUrl(longUrl, key);
        } else {
            return urlService.encodeUrl(longUrl);
        }
    }
}
