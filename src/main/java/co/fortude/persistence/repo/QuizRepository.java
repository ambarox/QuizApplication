package co.fortude.persistence.repo;

import co.fortude.persistence.model.Quiz;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;


public interface QuizRepository extends CrudRepository<Quiz, Long> {
    Optional<Quiz> findById(Long id);

    @Override
    void deleteById(Long aLong);
}
