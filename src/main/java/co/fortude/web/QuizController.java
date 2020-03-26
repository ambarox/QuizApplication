package co.fortude.web;

import co.fortude.persistence.model.Scores;
import co.fortude.persistence.mapper.QuizSheetMapper;
import co.fortude.persistence.repo.ScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import co.fortude.persistence.model.Quiz;
import co.fortude.persistence.repo.QuizRepository;
import org.springframework.web.servlet.view.RedirectView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class QuizController {

    @Autowired
    private QuizRepository quizRepository;

    @Autowired
    private ScoreRepository scoreRepository;

    @GetMapping("/create")
    public String createQuizPage(Model model) {
        model.addAttribute("quiz", new Quiz());
        return "create";
    }

    @PostMapping("/create")
    public String createQuiz(@ModelAttribute Quiz quiz, Model model) {
        quiz.setQuizDate(new Date());
        Quiz savedQuiz = quizRepository.save(quiz);
        model.addAttribute("quiz", savedQuiz);
        model.addAttribute("quizSheet", new QuizSheetMapper());
        return "quizSheet";
    }

    @PostMapping("/submitQuizSheet")
    public RedirectView createQuizSheet(@ModelAttribute QuizSheetMapper quizSheet) {
        List<Scores> quizSheets = mapToScoreList(quizSheet);
        Iterable<Scores> s = scoreRepository.saveAll(quizSheets);
        return new RedirectView("/");
    }

    private List<Scores> mapToScoreList(QuizSheetMapper quizSheet){
        List<Scores> quizSheets = new ArrayList<>();
        Quiz auiz = quizRepository.findById(quizSheet.getQuizId()).get();

        Scores team1 = new Scores();
        team1.setTeamName(quizSheet.getTeam1Name());
        team1.setRound1(quizSheet.getT1r1Score());
        team1.setRound2(quizSheet.getT1r2Score());
        team1.setRound3(quizSheet.getT1r3Score());
        team1.setRound4(quizSheet.getT1r4Score());
        team1.setRound5(quizSheet.getT1r5Score());
        team1.setTotal(quizSheet.getT1Total());
        team1.setPosition(quizSheet.getT1Position());
        team1.setQuiz(auiz);
        quizSheets.add(team1);

        Scores team2 = new Scores();
        team2.setTeamName(quizSheet.getTeam2Name());
        team2.setRound1(quizSheet.getT2r1Score());
        team2.setRound2(quizSheet.getT2r2Score());
        team2.setRound3(quizSheet.getT2r3Score());
        team2.setRound4(quizSheet.getT2r4Score());
        team2.setRound5(quizSheet.getT2r5Score());
        team2.setTotal(quizSheet.getT2Total());
        team2.setPosition(quizSheet.getT2Position());
        team2.setQuiz(auiz);
        quizSheets.add(team2);

        Scores team3 = new Scores();
        team3.setTeamName(quizSheet.getTeam3Name());
        team3.setRound1(quizSheet.getT3r1Score());
        team3.setRound2(quizSheet.getT3r2Score());
        team3.setRound3(quizSheet.getT3r3Score());
        team3.setRound4(quizSheet.getT3r4Score());
        team3.setRound5(quizSheet.getT3r5Score());
        team3.setTotal(quizSheet.getT3Total());
        team3.setPosition(quizSheet.getT3Position());
        team3.setQuiz(auiz);
        quizSheets.add(team3);

        Scores team4 = new Scores();
        team4.setTeamName(quizSheet.getTeam4Name());
        team4.setRound1(quizSheet.getT4r1Score());
        team4.setRound2(quizSheet.getT4r2Score());
        team4.setRound3(quizSheet.getT4r3Score());
        team4.setRound4(quizSheet.getT4r4Score());
        team4.setRound5(quizSheet.getT4r5Score());
        team4.setTotal(quizSheet.getT4Total());
        team4.setPosition(quizSheet.getT4Position());
        team4.setQuiz(auiz);
        quizSheets.add(team4);

        Scores team5 = new Scores();
        team5.setTeamName(quizSheet.getTeam5Name());
        team5.setRound1(quizSheet.getT5r1Score());
        team5.setRound2(quizSheet.getT5r2Score());
        team5.setRound3(quizSheet.getT5r3Score());
        team5.setRound4(quizSheet.getT5r4Score());
        team5.setRound5(quizSheet.getT5r5Score());
        team5.setTotal(quizSheet.getT5Total());
        team5.setPosition(quizSheet.getT5Position());
        team5.setQuiz(auiz);
        quizSheets.add(team5);

        return quizSheets;
    }

}
