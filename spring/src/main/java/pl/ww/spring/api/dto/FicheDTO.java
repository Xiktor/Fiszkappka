package pl.ww.spring.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotEmpty;

public class FicheDTO {

    @JsonProperty("id")
    private Integer id;

    @JsonProperty("wordInMotherLanguage")
    @NotEmpty(message = "Proszę podać termin w ojczystym języku...")
    private String wordInMotherLanguage;

    @JsonProperty("wordInForeignLanguage")
    @NotEmpty(message = "Proszę podać termin w języku obcym...")
    private String wordInForeignLanguage;

    @JsonProperty("languageId")
    private Integer languageId;

    @JsonProperty("languageName")
    private String languageName;

    public FicheDTO() {
    }

    public FicheDTO(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getWordInMotherLanguage() {
        return wordInMotherLanguage;
    }

    public void setWordInMotherLanguage(String wordInMotherLanguage) {
        this.wordInMotherLanguage = wordInMotherLanguage;
    }

    public String getWordInForeignLanguage() {
        return wordInForeignLanguage;
    }

    public void setWordInForeignLanguage(String wordInForeignLanguage) {
        this.wordInForeignLanguage = wordInForeignLanguage;
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
}
