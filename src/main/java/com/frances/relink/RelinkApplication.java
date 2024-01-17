package com.frances.relink;

import com.frances.relink.controllers.UrlController;
import com.frances.relink.models.Url;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class RelinkApplication {

    public static void main(String[] args) {
        SpringApplication.run(RelinkApplication.class, args);
    }

}
