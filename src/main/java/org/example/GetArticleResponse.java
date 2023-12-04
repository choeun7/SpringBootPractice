package org.example;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GetArticleResponse {

    @JsonProperty("number") //JSON에 반환되는 key 값을 이 이름으로 지정할 수 있다.
    public int num;

    public String title;

}
