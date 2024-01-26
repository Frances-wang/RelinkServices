package com.frances.relink.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
@Table(name="URL")
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Url implements Serializable {

    @jakarta.persistence.Id
    @Id
    @Column(name="ID_URL")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="LONG_URL")
    @NotNull
    private String longUrl;
    @Column(name="SHORT_URL")
    private String shortUrl;

    public Url(String longUrl) {
        this.longUrl = longUrl;
    }
}
