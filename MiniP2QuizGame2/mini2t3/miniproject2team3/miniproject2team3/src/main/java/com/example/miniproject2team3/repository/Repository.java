package com.example.miniproject2team3.repository;

import com.example.miniproject2team3.service.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface  Repository extends JpaRepository<Question, Long> {


}
