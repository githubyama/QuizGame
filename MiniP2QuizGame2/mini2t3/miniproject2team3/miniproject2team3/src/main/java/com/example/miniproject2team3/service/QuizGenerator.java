package com.example.miniproject2team3.service;


import com.example.miniproject2team3.repository.Repository;
import com.example.miniproject2team3.repository.ResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import java.util.List;

@Service
@SessionScope
public class QuizGenerator {

    @Autowired
    Repository repository;
    @Autowired
    ResultRepository rRepository;
    List<Question> questionList;
    int score=0;
    int currentQuestion=0;
    int currentQueId =0;


   // public QuizGenerator() {
        //   this.repository = repository;
        // this.questionList= repository.findAll();
   // }

    public QuizGenerator(List<Question> questionList, int score, int currentQuestion, int currentQueId) {
        this.questionList = repository.findAll();
        this.score = score;
        this.currentQuestion = currentQuestion;
        this.currentQueId = currentQueId;
    }

    public QuizGenerator() {

    }

    /*
    @Autowired
    Question question;

    */

    public Question currentQuestion(){
        questionList = repository.findAll();
        return questionList.get(currentQuestion);
    }

    public  boolean nextQuestion(){
       currentQuestion++;
       return currentQuestion >=questionList.size();

    }

    public List<Question> displayQuestions(){
        return repository.findAll();

    }

    public int scoreIncrease() {
        score++;
        return score;

    }

    public int getScore() {
        return score;
    }
    // public String checkAnswer(QandARepository questions){
     //   if(correctAnswer[] == userrinput)
   // }

  public int idIncrease() {
        currentQueId++;
        return currentQueId;

    }

    public int getCurrentQueId() {
        return currentQueId;
    }

    public void saveScores (Result result) {
        Result saveResults = new Result();
        saveResults.setUsername(result.getUsername());
        saveResults.setTotalScore(result.getTotalScore());
        rRepository.save(saveResults);
    }

    public void newGame() {
        score=0;
        currentQuestion=0;
        currentQueId =0;
    }
}
