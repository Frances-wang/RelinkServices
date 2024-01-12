package com.frances.relink.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Entity
@Data
@NoArgsConstructor
@Table(name="URL")
public class Url {

    @jakarta.persistence.Id
    @Id
    @Column(name="ID_URL")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="LONG_URL")
    private String longUrl;
    @Column(name="SHORT_URL")
    private String shortUrl;

    public Url(String longUrl) {
        this.longUrl = longUrl;
    }
}
