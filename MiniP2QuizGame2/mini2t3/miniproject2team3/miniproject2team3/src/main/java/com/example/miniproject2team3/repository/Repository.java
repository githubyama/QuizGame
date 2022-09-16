package com.example.miniproject2team3.repository;

import com.example.miniproject2team3.service.Question;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface Repository extends CrudRepository<Question, Long> {

    List<Question> findAll();

}
