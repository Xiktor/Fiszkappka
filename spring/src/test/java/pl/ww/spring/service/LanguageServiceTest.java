package pl.ww.spring.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import pl.ww.spring.model.Language;
import pl.ww.spring.repository.LanguageRepository;

import java.util.Arrays;
import java.util.Optional;
import java.util.stream.StreamSupport;

import static org.mockito.Mockito.doReturn;

@SpringBootTest
public class LanguageServiceTest {

    @Autowired
    private LanguageService service;

    @MockBean
    private LanguageRepository repository;

    @Test
    void listAll_whenFound_thenReturnResult() {
        Language language = new Language(1, "Holenderski");
        Language language2 = new Language(2, "Niemiecki");
        doReturn(
                Arrays.asList(language, language2)
        )
                .when(
                        repository
                )
                .findAll();

        Iterable<Language> languages = service.listAll();

        Assertions.assertEquals(
                2,
                StreamSupport.stream(languages.spliterator(), false).count()
        );
    }

    @Test
    void find_whenFound_thenReturnResult() {
        Language language = new Language(1, "Holenderski");
        doReturn(Optional.of(language)).when(repository).findById(1);

        Language result = service.find(1);

        Assertions.assertTrue((result != null) );
        Assertions.assertSame(result, language);
    }

    @Test
    void find_whenNotFound_thenReturnNull() {
        doReturn(Optional.empty()).when(repository).findById(1);

        Language result = service.find(1);

        Assertions.assertTrue((result == null) );
    }

    @Test
    void save_whenSaved_thenReturnResult() {
        Language language = new Language(1, "Holenderski");

        service.save(language);
    }

    @Test
    void delete_whenDeleted_thenReturnResult() {
        Language language = new Language(1, "Holenderski");
        service.delete(language.getId());
    }
}
