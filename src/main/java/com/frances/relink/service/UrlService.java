package com.frances.relink.service;

import com.frances.relink.data.UrlRepository;
import com.frances.relink.exception.LongUrlDoesNotExistsException;
import com.frances.relink.exception.ShortenLinkExistsException;
import com.frances.relink.models.Url;
import org.springframework.cache.annotation.CachePut;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;

@Service
public class UrlService {
    private final UrlRepository urlRepository;
    private final String baseUrl;
    private final String salt;

    public UrlService(UrlRepository urlRepository) {
        this.urlRepository = urlRepository;
        this.baseUrl = "http://localhost:8080/re.link/";
        this.salt = "salt";
    }

    public String hashing(String url) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(url.getBytes());
            BigInteger mdlongUrl = new BigInteger(1, messageDigest);
            StringBuilder hashtext = new StringBuilder(mdlongUrl.toString(16));
            while (hashtext.length() < 7) {
                hashtext.insert(0, "0");
            }
            return hashtext.toString();
        }
        catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public Url saveUrl(Url url) {
        return urlRepository.save(url);
    }

    public Url saveUrl(Url url, String key) throws ShortenLinkExistsException {
        Url resUrl = urlRepository.findByShortUrl(this.baseUrl+key);
        if (resUrl != null) {
            if (resUrl.getLongUrl().equals(url.getLongUrl())) {
                return resUrl;
            }
            throw new ShortenLinkExistsException();
        }
        url.setShortUrl(this.baseUrl+key);
        return saveUrl(url);
    }

    public Url encodeUrl(Url longUrl) {
        Url keyUrl = urlRepository.findByLongUrl(longUrl.getLongUrl());
        if (keyUrl != null) {
            return keyUrl;
        }

        String key = hashing(longUrl.getLongUrl()).substring(0,7);
        while (urlRepository.findByShortUrl(this.baseUrl+key) != null) {
            key = hashing(key + salt);
        }
        longUrl.setShortUrl(this.baseUrl+key);
        return saveUrl(longUrl);
    }

    public Url decodeUrl(String key) throws LongUrlDoesNotExistsException {
        Url url = urlRepository.findByShortUrl(this.baseUrl+key);
        if (url == null) {
            throw new LongUrlDoesNotExistsException();
        }
        return url;
    }
}
