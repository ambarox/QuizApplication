package co.fortude.web;

import co.fortude.persistence.model.Scores;
import co.fortude.persistence.model.Quiz;
import co.fortude.persistence.repo.QuizRepository;
import co.fortude.persistence.repo.ScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class MainController {

    @Value("${spring.application.name}")
    String appName;

    @Autowired
    private QuizRepository quizRepository;

    @Autowired
    private ScoreRepository scoreRepository;

    @RequestMapping("/")
    public String quizPage(Model model) {
        Iterable<Quiz> allQuizzes = quizRepository.findAll();
        model.addAttribute("allQuizzes", allQuizzes);
        return "quiz";
    }

    @RequestMapping("/viewResults/{quizId}")
    public String viewResults(@PathVariable("quizId") Long quizId,  Model model) {
        Iterable<Scores> scores = scoreRepository.findAllByQuiz_Id(quizId);
        model.addAttribute("scores", scores);
        return "viewResults";
    }

    @RequestMapping("/deleteResults/{quizId}")
    public RedirectView deleteResults(@PathVariable("quizId") Long quizId,  Model model) {
        quizRepository.deleteById(quizId);
        return new RedirectView("/");
    }
}
