package com.search.engine;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SearchController {

    @GetMapping("/api/health")
    public String healthCheck(){
        return "Search Engine is Running!";
    }

    @GetMapping("/api/search")
    public String search(@RequestParam(name = "q") String query){
        return "검색 결과: '" + query + "' 에 대한 문서를 찾았습니다. (Mock API)";
    }
}
