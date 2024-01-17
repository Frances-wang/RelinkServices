package com.frances.relink;

import com.frances.relink.controllers.UrlController;
import com.frances.relink.models.Url;
import org.junit.jupiter.api.Test;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootTest
class RelinkApplicationTests {

//    ConfigurableApplicationContext context = SpringApplication.run(RelinkApplication.class, args);
//    com.frances.relink.controllers.UrlController UrlController = context.getBean(UrlController.class);
//    Url test_url = new Url("testtest");
//        System.out.println(UrlController.getUrl(UrlController.saveUrl(test_url).getShortUrl()).getLongUrl());
//        System.out.println(UrlController.saveUrl(test_url));
//    Url test_duplicate = new Url("duplicate!");
//        System.out.println(UrlController.saveUrl(test_duplicate, "5a671c6"));
//    Url test_url1 = new Url("test");
//        System.out.println(UrlController.saveUrl(test_url1));

    @Test
    void contextLoads() {
    }

}
