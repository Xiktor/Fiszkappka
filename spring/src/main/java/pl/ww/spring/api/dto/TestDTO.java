package pl.ww.spring.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class TestDTO {

    @JsonProperty("id")
    private Integer id;

    @JsonProperty("score")
    private String score;

    @JsonProperty("resolved")
    private Date resolved;

    @JsonProperty("languageId")
    private Integer languageId;

    @JsonProperty("languageName")
    private String languageName;

    @JsonProperty("question1")
    private String question1;

    @JsonProperty("question2")
    private String question2;

    @JsonProperty("question3")
    private String question3;

    @JsonProperty("correctAnswer1")
    private String correctAnswer1;

    @JsonProperty("correctAnswer2")
    private String correctAnswer2;

    @JsonProperty("correctAnswer3")
    private String correctAnswer3;

    @JsonProperty("userAnswer1")
    private String userAnswer1;

    @JsonProperty("userAnswer2")
    private String userAnswer2;

    @JsonProperty("userAnswer3")
    private String userAnswer3;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public Date getResolved() {
        return resolved;
    }

    public void setResolved(Date resolved) {
        this.resolved = resolved;
    }

    public Integer getLanguageId() {
        return languageId;
    }

    public void setLanguageId(Integer languageId) {
        this.languageId = languageId;
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
