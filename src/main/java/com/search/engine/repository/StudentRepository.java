package com.search.engine.repository;

import com.search.engine.domain.Student;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends ElasticsearchRepository<Student, String> {
    //메서드 이름만 형식에 맞춰서 지으면 쿼리를 대신 짜줌.
    //"name"필드에서 찾기
    List<Student> findByName(String name);

    //"description"에 특정 단어가 포함된 것 찾기(검색 핵심)
    List<Student> findByDescriptionContaining(String keyword);

}
