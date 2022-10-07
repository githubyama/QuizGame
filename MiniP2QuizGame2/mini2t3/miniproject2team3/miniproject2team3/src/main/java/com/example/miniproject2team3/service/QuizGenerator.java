package com.example.miniproject2team3.service;


import com.example.miniproject2team3.repository.Repository;
import com.example.miniproject2team3.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import java.util.Collections;
import java.util.List;

@Service
@SessionScope
public class QuizGenerator {

    @Autowired
    Repository repository;
    @Autowired
    UserRepository userRepository;
    List<Question> questionList;

    Player player;
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
      //  Collections.shuffle(questionList);
        return questionList.get(currentQuestion);
    }

    public  boolean nextQuestion(){
       currentQuestion++;
       return currentQuestion >=10;

    }

    public List<Question> displayQuestions(){
        List<Question> allQuestions = repository.findAll();
        Collections.shuffle(allQuestions);
        return allQuestions;

    }



    public int scoreIncrease() {
        score++;
        return score;

    }

    public int getScore() {
        return score;
    }

  public int idIncrease() {
        currentQueId++;
        return currentQueId;
    }

    public int getCurrentQueId() {
        return currentQueId;
    }

    public void saveScore (int result) {
        player.addScore(result);
        userRepository.save(player);
    }

    public void newGame() {
        score=0;
        currentQuestion=0;
        currentQueId =0;
    }

    public void logIn(String username) {
       List<Player> playerList = userRepository.findByName(username);
       if (playerList.size()>0) {
           player = playerList.get(0);
       }
       else {
           player = userRepository.save(new Player(username));

       }
    }

    public String getTopScore() {
        List<Player> players = userRepository.findAll();
        int highScore = 0;
        String playerWithHighestScore = "";
        for (Player p : players) {
            for (Result r: p.results) {
                if (r.totalScore >highScore) {
                    highScore = r.totalScore;
                    playerWithHighestScore = p.getName();
                }
            }
        }
        return " Player with the highest score:\n" +  playerWithHighestScore + " "  + highScore;

    }

}
