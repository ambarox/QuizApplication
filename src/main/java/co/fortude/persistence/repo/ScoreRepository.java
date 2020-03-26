package co.fortude.persistence.repo;

import co.fortude.persistence.model.Scores;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface ScoreRepository extends JpaRepository<Scores, Long> {
    List<Scores> findAllByQuiz_Id(Long quizId);
}