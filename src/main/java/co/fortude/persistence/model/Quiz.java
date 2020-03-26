package co.fortude.persistence.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Quiz {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false)
    private String quizMasters;

    @Column(nullable = false)
    private Date quizDate;

    @OneToMany(mappedBy = "quiz",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Scores> scores = new ArrayList<>();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getQuizMasters() {
        return quizMasters;
    }

    public void setQuizMasters(String quizMasters) {
        this.quizMasters = quizMasters;
    }

    public Date getQuizDate() {
        return quizDate;
    }

    public void setQuizDate(Date quizDate) {
        this.quizDate = quizDate;
    }

    public List<Scores> getScores() {
        return scores;
    }

    public void setScores(List<Scores> scores) {
        this.scores = scores;
    }
}