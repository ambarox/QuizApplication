package co.fortude.persistence.model;

import javax.persistence.*;

@Entity
public class Scores {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false)
    private String teamName;

    @Column(nullable = true)
    private Integer round1;

    @Column(nullable = true)
    private Integer round2;

    @Column(nullable = true)
    private Integer round3;

    @Column(nullable = true)
    private Integer round4;

    @Column(nullable = true)
    private Integer round5;

    @Column(nullable = true)
    private Integer total;

    @Column(nullable = true)
    private Integer position;

    @ManyToOne
    private Quiz quiz;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public Integer getRound1() {
        return round1;
    }

    public void setRound1(Integer round1) {
        this.round1 = round1;
    }

    public Integer getRound2() {
        return round2;
    }

    public void setRound2(Integer round2) {
        this.round2 = round2;
    }

    public Integer getRound3() {
        return round3;
    }

    public void setRound3(Integer round3) {
        this.round3 = round3;
    }

    public Integer getRound4() {
        return round4;
    }

    public void setRound4(Integer round4) {
        this.round4 = round4;
    }

    public Integer getRound5() {
        return round5;
    }

    public void setRound5(Integer round5) {
        this.round5 = round5;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public Quiz getQuiz() {
        return quiz;
    }

    public void setQuiz(Quiz quiz) {
        this.quiz = quiz;
    }
}
