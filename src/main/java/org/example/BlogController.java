package org.example;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.stream.Collectors;

@RestController
public class BlogController {
    @Value("${mju.blog.articles_per_page}")
    int articlesPerPage;

    @GetMapping("/hello")
    public String hello() {
        return "world" + articlesPerPage;
    }

    @GetMapping("/config/articles_per_page")
    public int getArticlesPerPage() {
        return articlesPerPage;
    }

    @GetMapping("/article/titles")
    public Object getArticleTitles() {
        ArrayList<String> a = new ArrayList();
        a.add("제목1");
        a.add("제목2");
        return a;
    }

    @GetMapping("/article/{number}")
    public Object getArticle(@PathVariable int number) {    //다른 이름으로 쓰고 싶으면 int articleNumber로 변경 가능
        GetArticleResponse r = new GetArticleResponse();
        r.num = number;
        r.title = "즐거운 하루";
        return r;
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

    @PostMapping("/article")
    public void postArticle(@RequestBody PostArticleRequest body) {
        System.out.println(body.title);
    }


}
