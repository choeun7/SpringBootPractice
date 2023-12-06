package org.example;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ArticleManager {
    private List<String> titles;

    @PostConstruct
    public void init() {
        titles = new ArrayList<String>();
        titles.add("제목1");
        titles.add("제목2");
    }

    public List<String> getTitles() {
        return titles;
    }

    public String getTitleAt(int index) {
        return titles.get(index);
    }
}
