package pl.ww.spring.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.ww.spring.model.Fiche;

import java.util.List;

@Repository
public interface FicheRepository extends CrudRepository<Fiche, Integer> {

    @Query(value = "SELECT MAX(id) FROM fiche", nativeQuery = true)
    public Integer findMaxId();

    @Query(value = "SELECT * FROM fiche WHERE language_id = ?1", nativeQuery = true)
    public List<Fiche> findFichesByLanguageId(Integer id);

}
