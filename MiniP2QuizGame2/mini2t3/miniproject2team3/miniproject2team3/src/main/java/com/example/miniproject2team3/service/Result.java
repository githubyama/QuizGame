package com.example.miniproject2team3.service;

import org.springframework.stereotype.Service;

import javax.persistence.*;

@Service
@Entity
public class Result {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    String username;
    int totalScore = 0;


    public Result() {
    }

    public Result(Long id, String username, int totalScore) {
        this.id = id;
        this.username = username;
        this.totalScore = totalScore;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(int totalScore) {
        this.totalScore = totalScore;
    }
}
