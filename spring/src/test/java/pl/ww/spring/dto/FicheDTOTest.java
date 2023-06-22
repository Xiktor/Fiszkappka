package pl.ww.spring.dto;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import pl.ww.spring.api.dto.FicheDTO;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class FicheDTOTest {

    @Test
    public void testId() {
        FicheDTO ficheDTO = new FicheDTO();
        Integer expectedId = 1;

        ficheDTO.setId(expectedId);
        Integer actualId = ficheDTO.getId();

        assertEquals(expectedId, actualId);
    }

    @Test
    public void testWordInMotherLanguage() {
        FicheDTO ficheDTO = new FicheDTO();
        String expectedWordInMotherLanguage = "czerwony";

        ficheDTO.setWordInMotherLanguage(expectedWordInMotherLanguage);
        String actualWordInMotherLanguage = ficheDTO.getWordInMotherLanguage();

        assertEquals(expectedWordInMotherLanguage, actualWordInMotherLanguage);
    }

    @Test
    public void testWordInForeignLanguage() {
        FicheDTO ficheDTO = new FicheDTO();
        String expectedWordInForeignLanguage = "red";

        ficheDTO.setWordInForeignLanguage(expectedWordInForeignLanguage);
        String actualWordInForeignLanguage = ficheDTO.getWordInForeignLanguage();

        assertEquals(expectedWordInForeignLanguage, actualWordInForeignLanguage);
    }

    @Test
    public void testLanguageId() {
        FicheDTO ficheDTO = new FicheDTO();
        Integer expectedLanguageId = 1;

        ficheDTO.setLanguageId(expectedLanguageId);
        Integer actualLanguageId = ficheDTO.getLanguageId();

        assertEquals(expectedLanguageId, actualLanguageId);
    }

    @Test
    public void testLanguageName() {
        FicheDTO ficheDTO = new FicheDTO();
        String expectedLanguageName = "Angielski";

        ficheDTO.setLanguageName(expectedLanguageName);
        String actualLanguageName = ficheDTO.getLanguageName();

        assertEquals(expectedLanguageName, actualLanguageName);
    }

}
