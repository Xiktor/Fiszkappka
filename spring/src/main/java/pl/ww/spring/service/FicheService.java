package pl.ww.spring.service;


import org.springframework.stereotype.Service;
import pl.ww.spring.exception.NoFichesException;
import pl.ww.spring.exception.NotEnoughFichesException;
import pl.ww.spring.exception.NotFoundException;
import pl.ww.spring.model.Fiche;
import pl.ww.spring.repository.FicheRepository;

import javax.transaction.Transactional;
import java.util.Collections;
import java.util.List;
import java.util.Random;

@Service
@Transactional
public class FicheService {

    private final FicheRepository ficheRepository;

    public FicheService(FicheRepository ficheRepository) {
        this.ficheRepository = ficheRepository;
    }

    public Iterable<Fiche> listAll() {
        return ficheRepository.findAll();
    }

    public void save(Fiche fiche) {
        ficheRepository.save(fiche);
    }

    public Fiche find(Integer id) {
        return ficheRepository.findById(id).orElse(null);
    }

    public void delete(Integer id) {
        ficheRepository.deleteById(id);
    }

    public Fiche getRandomFiche() throws NoFichesException {
        var ficheCount = ficheRepository.findMaxId();
        if (ficheCount == null || ficheCount == 0) {
            throw new NoFichesException("W bazie nie ma żadnych fiszek");
        }
        Random rand = new Random();
        int randomFicheId = rand.nextInt(ficheCount) + 1;
        Fiche fiche = null;
        while (fiche == null) {
            fiche = ficheRepository.findById(randomFicheId).orElse(null);
            if (fiche == null) {
                randomFicheId = rand.nextInt(ficheCount) + 1;
            }
        }

        return fiche;
    }

    public boolean checkout(Integer id, String wordInForeignLanguage) {
        Fiche fiche = this.find(id);

        return fiche.getWordInForeignLanguage().equalsIgnoreCase(wordInForeignLanguage);
    }

    public List<Fiche> getFichesForTest(Integer language_id) throws NotEnoughFichesException {
        List<Fiche> fiches = ficheRepository.findFichesByLanguageId(language_id);
        if (fiches == null || fiches.size() <  3) {
            throw new NotEnoughFichesException("ten język ma za mało fiszek");
        }
        Collections.shuffle(fiches);

        return fiches.subList(0, 3);
    }
}
