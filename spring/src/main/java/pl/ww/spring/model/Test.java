package pl.ww.spring.model;

import org.hibernate.annotations.OnDelete;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "test")
public class Test {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;

    @Column(name = "score", nullable = false)
    private Integer score;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "resolved", length = 19)
    private Date resolved;

    @Column(name = "language_name")
    private String languageName;

    @Column(name="question1")
    private String question1;

    @Column(name="question2")
    private String question2;

    @Column(name="question3")
    private String question3;

    @Column(name="correct_answer1")
    private String correctAnswer1;

    @Column(name="correct_answer2")
    private String correctAnswer2;

    @Column(name="correct_answer3")
    private String correctAnswer3;

    @Column(name="user_answer1")
    private String userAnswer1;

    @Column(name="user_answer2")
    private String userAnswer2;

    @Column(name="user_answer3")
    private String userAnswer3;

    public Test() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Date getResolved() {
        return resolved;
    }

    public void setResolved(Date resolved) {
        this.resolved = resolved;
    }

    public String getLanguageName() {
        return languageName;
    }

    public void setLanguageName(String languageName) {
        this.languageName = languageName;
    }

    public String getQuestion1() {
        return question1;
    }

    public void setQuestion1(String question1) {
        this.question1 = question1;
    }

    public String getQuestion2() {
        return question2;
    }

    public void setQuestion2(String question2) {
        this.question2 = question2;
    }

    public String getQuestion3() {
        return question3;
    }

    public void setQuestion3(String question3) {
        this.question3 = question3;
    }

    public String getCorrectAnswer1() {
        return correctAnswer1;
    }

    public void setCorrectAnswer1(String correctAnswer1) {
        this.correctAnswer1 = correctAnswer1;
    }

    public String getCorrectAnswer2() {
        return correctAnswer2;
    }

    public void setCorrectAnswer2(String correctAnswer2) {
        this.correctAnswer2 = correctAnswer2;
    }

    public String getCorrectAnswer3() {
        return correctAnswer3;
    }

    public void setCorrectAnswer3(String correctAnswer3) {
        this.correctAnswer3 = correctAnswer3;
    }

    public String getUserAnswer1() {
        return userAnswer1;
    }

    public void setUserAnswer1(String userAnswer1) {
        this.userAnswer1 = userAnswer1;
    }

    public String getUserAnswer2() {
        return userAnswer2;
    }

    public void setUserAnswer2(String userAnswer2) {
        this.userAnswer2 = userAnswer2;
    }

    public String getUserAnswer3() {
        return userAnswer3;
    }

    public void setUserAnswer3(String userAnswer3) {
        this.userAnswer3 = userAnswer3;
    }
}
