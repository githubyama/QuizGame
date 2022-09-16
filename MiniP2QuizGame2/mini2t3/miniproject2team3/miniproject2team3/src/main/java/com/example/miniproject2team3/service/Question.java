package com.example.miniproject2team3.service;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@Entity

public class Question {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String prompt;
    private String optionA;
    private String optionB;
    private String optionC;
   // String [] answers;
    @Column(name = "correct_answer", nullable = false)
    private int correctAnswer;


    public Question() {
    }

    public Question(String prompt, String optionA, String optionB, String optionC, int correctAnswer) {

        this.prompt = prompt;
        this.optionA = optionA;
        this.optionB = optionB;
        this.optionC = optionC;
        this.correctAnswer = correctAnswer;
    }

   // public String[] getAnswers() {
    //    return answers;
 //   }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPrompt() {
        return prompt;
    }

    public void setPrompt(String prompt) {
        this.prompt = prompt;
    }

    public String getOptionA() {
        return optionA;
    }

    public void setOptionA(String optionA) {
        this.optionA = optionA;
    }

    public String getOptionB() {
        return optionB;
    }

    public void setOptionB(String optionB) {
        this.optionB = optionB;
    }

    public String getOptionC() {
        return optionC;
    }

    public void setOptionC(String optionC) {
        this.optionC = optionC;
    }

    public int getCorrectAnswer() {
        return correctAnswer;
    }

    public String getCorrectAnswerString() {
        switch (getCorrectAnswer()) {
            case 1: return optionA;
            case 2: return optionB;
            case 3: return optionC;
            default: throw new IllegalArgumentException();
        }
    }

    public void setCorrectAnswer(int correctAnswer) {
        this.correctAnswer = correctAnswer;
    }
}

   /* @Override
    public String toString() {
        return  prompt  + "\n" +
              "  \n Options : " + Arrays.toString(answers) ;
    }*/


