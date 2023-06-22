package pl.ww.spring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.ww.spring.model.Test;

@Repository
public interface TestRepository extends CrudRepository<Test, Integer> {
}
