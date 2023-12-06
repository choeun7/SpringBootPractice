package org.example;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import org.slf4j.Logger;
import java.util.stream.Collectors;

@RestController
public class BlogController {

    @Autowired
    private ArticleManager articleManager;

    Logger logger = LoggerFactory.getLogger(BlogController.class);

    @Value("${mju.blog.articles_per_page}")
    int articlesPerPage;

    @GetMapping("/hello")
    public String hello() {
        logger.debug("hello");
        logger.info("hello");
        logger.warn("hello");
        logger.error("hello");

        return "world" + articlesPerPage;
    }

    @GetMapping("/config/articles_per_page")
    public int getArticlesPerPage() {
        return articlesPerPage;
    }


//    @PostMapping("/article")
//    public void postArticle(HttpServletRequest request, HttpServletResponse response)
//            throws IOException {
//        System.out.println(request.getMethod());
//
//        BufferedReader in = new BufferedReader(
//                new InputStreamReader(request.getInputStream(), StandardCharsets.UTF_8));
//        String payload = in.lines().collect(Collectors.joining());
//        System.out.println(payload);
//        response.addHeader("MY_HEADER", "MY_VALUE");
//        response.getOutputStream().println("Hello");
//    }

//    방법 #1: HttpServletResponse 객체의 메서드를 이용 (매개변수 위치 관계 X)
    @GetMapping("/error1/{code}")
    public void getStatusCode1(@PathVariable int code, HttpServletResponse response) {
        response.setStatus(code);
    }

//    방법 #2: handler 가 ResponseEntity 를 반환하는 방법
    @GetMapping("/error2/{code}")
    public ResponseEntity<?> getStatusCode2(@PathVariable int code) {
        HttpStatusCode code2 = HttpStatusCode.valueOf(code);
        return new ResponseEntity<>(code2);
    }

//    방법 #3: ResponseStatusException 을 throw 하는 방법
    @GetMapping("/error3/{code}")
    public void getStatusCode3(@PathVariable int code) {
        HttpStatusCode code2 = HttpStatusCode.valueOf(code);
        throw new ResponseStatusException(code2);
    }

    @GetMapping("/article/titles")
    public Object getArticleTitles() {
        return articleManager.getTitles();
    }
    @GetMapping("/article/{number}")
    public Object getArticle(@PathVariable int number) {
        GetArticleResponse r = new GetArticleResponse();
        r.num = number;
        r.title = articleManager.getTitleAt(number);
        return r;
    }
    @PostMapping("/article")
    public void postArticle(@RequestBody PostArticleRequest body) {
        articleManager.getTitles().add(body.title);
    }


}
