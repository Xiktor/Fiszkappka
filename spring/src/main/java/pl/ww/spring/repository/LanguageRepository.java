package pl.ww.spring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.ww.spring.model.Language;

@Repository
public interface LanguageRepository extends CrudRepository<Language, Integer> {
}
