package pl.ww.spring.model;

import javax.persistence.*;

@Entity
@Table(name = "fiche")
public class Fiche {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;

    @Column(name = "word_in_mother_language", nullable = false)
    private String wordInMotherLanguage;

    @Column(name = "word_in_foreign_language", nullable = false)
    private String wordInForeignLanguage;

    @ManyToOne
    @JoinColumn(name = "language_id")
    private Language language;

    public Fiche() {
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

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }
}
