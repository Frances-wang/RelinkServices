package com.frances.relink.data;

import com.frances.relink.models.Url;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UrlRepository extends JpaRepository<Url, Long> {
    Url findByLongUrl(String longUrl);
    Url findByShortUrl(String shortUrl);
}
