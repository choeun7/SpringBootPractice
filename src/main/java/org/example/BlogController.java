package org.example;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BlogController {
    @Value("${mju.blog.articles_per_page}")
    int articlePerPage;

    @GetMapping("/hello")
    public String hello() {
        return "world" + articlePerPage;
    }
}
