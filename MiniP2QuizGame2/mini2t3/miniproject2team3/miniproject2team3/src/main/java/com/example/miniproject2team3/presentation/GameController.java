package com.example.miniproject2team3.presentation;

import com.example.miniproject2team3.repository.Repository;
import com.example.miniproject2team3.repository.ResultRepository;
import com.example.miniproject2team3.service.QandAForm;
import com.example.miniproject2team3.service.Question;
import com.example.miniproject2team3.service.QuizGenerator;
import com.example.miniproject2team3.service.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

@Controller
public class GameController {

    @Autowired
    QuizGenerator generator;

    @Autowired
    Result results;

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @PostMapping ("/quiz")
    public String username (Model model, @RequestParam String username, RedirectAttributes ra) {
        if (username.equals("")) {
            ra.addFlashAttribute("warning", "Enter a Valid Name!");
            return "redirect:/";
        }
        results.setUsername(username);
        model.addAttribute("username", username);
        return "redirect:/quiz";
    }

    @GetMapping("/quiz")
    public String questions(Model model) {
        if (generator == null) {
            generator = new QuizGenerator();
        }
        Question q = generator.currentQuestion();
         int id = generator.idIncrease();
        model.addAttribute("question", q);
        model.addAttribute("questionid", id);
        return "gamepage";

    }

    @PostMapping("/answer")
    public String answer(Model model, @RequestParam int answerNumber) {
        Question q = generator.currentQuestion();

        if (q.getCorrectAnswer() == answerNumber) {
            int score = generator.scoreIncrease();
            generator.saveScores(results);

            model.addAttribute("response", "Correct answer! score= " + score);
        } else {
            model.addAttribute("response", "Wrong answer! score= " + generator.getScore()
                    + "\n The correct answer is: " + q.getCorrectAnswer());
        }

        if (generator.nextQuestion()) {
            if (generator.getScore() >= 5) {
                model.addAttribute("finalscore", generator.getScore());
            //   session.invalidate();
                generator.newGame();

                return "endofgamepass";
            } else {
                model.addAttribute("finalscore", generator.getScore());
            //    session.invalidate();
                generator.newGame();
                return "endofgamefailed";
            }
        }  return "result";
    }
}
