package com.search.engine.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
//indexName = "students" : MySql의 @Talbe(name="students")와 동일
//createIndex = true: 앱 실행시 이 인덱스가 없으면 자동 생성
@Document(indexName = "students", createIndex = true)
public class Student {

    @Id//식별자
    private String id;

    private String name;

    private int age;

    private String description;//검색 대상(자기소개 텍스트)
}