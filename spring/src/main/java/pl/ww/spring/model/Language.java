package pl.ww.spring.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "language")
public class Language {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;

    @OneToMany(mappedBy = "language", cascade = CascadeType.REMOVE)
    private Set<Fiche> fiches = new HashSet<>();

    public Language() {
    }

    public Language(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Language(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Fiche> getFiches() {
        return fiches;
    }

    public void setFiches(Set<Fiche> fiches) {
        this.fiches = fiches;
    }
}
