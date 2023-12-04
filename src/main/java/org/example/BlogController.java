package org.example;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;

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

}
