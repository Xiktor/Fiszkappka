package pl.ww.spring.service;

import org.springframework.stereotype.Service;
import pl.ww.spring.api.dto.TestDTO;
import pl.ww.spring.exception.NotEnoughFichesException;
import pl.ww.spring.model.Fiche;
import pl.ww.spring.model.Test;
import pl.ww.spring.repository.TestRepository;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class TestService {

    private final TestRepository testRepository;
    private final FicheService ficheService;
    private final LanguageService languageService;

    public TestService(TestRepository testRepository, FicheService ficheService, LanguageService languageService) {
        this.testRepository = testRepository;
        this.ficheService = ficheService;
        this.languageService = languageService;
    }

    public Iterable<Test> listAll() {
        return testRepository.findAll();
    }

    public void save(Test test) {
        testRepository.save(test);
    }

    public Test find(Integer id) {
        return testRepository.findById(id).orElse(null);
    }

    public void delete(Integer id) {
        testRepository.deleteById(id);
    }

    public Test createNewTest(Integer languageId) throws NotEnoughFichesException {
        List<Fiche> fiches = ficheService.getFichesForTest(languageId);
        Test test = new Test();
        test.setLanguageName(languageService.find(languageId).getName());
        test.setQuestion1(fiches.get(0).getWordInMotherLanguage());
        test.setQuestion2(fiches.get(1).getWordInMotherLanguage());
        test.setQuestion3(fiches.get(2).getWordInMotherLanguage());
        test.setCorrectAnswer1(fiches.get(0).getWordInForeignLanguage());
        test.setCorrectAnswer2(fiches.get(1).getWordInForeignLanguage());
        test.setCorrectAnswer3(fiches.get(2).getWordInForeignLanguage());
        this.save(test);

        return test;
    }

    public Test checkAndReturn(TestDTO testTDO) {
        Test testWithAnswers = testRepository.findById(testTDO.getId()).orElse(null);
        int points = 0;
        points = this.checkAnswer(testTDO.getUserAnswer1(), testWithAnswers.getCorrectAnswer1()) ? points+1 : points;
        points = this.checkAnswer(testTDO.getUserAnswer2(), testWithAnswers.getCorrectAnswer2()) ? points+1 : points;
        points = this.checkAnswer(testTDO.getUserAnswer3(), testWithAnswers.getCorrectAnswer3()) ? points+1 : points;
        testWithAnswers.setResolved(new Date());
        testWithAnswers.setScore((points*100)/3);
        testWithAnswers.setUserAnswer1(testTDO.getUserAnswer1());
        testWithAnswers.setUserAnswer2(testTDO.getUserAnswer2());
        testWithAnswers.setUserAnswer3(testTDO.getUserAnswer3());
        this.save(testWithAnswers);

        return testWithAnswers;
    }

    private boolean checkAnswer(String userAnswer, String correctAnswer) {
        return userAnswer.equalsIgnoreCase(correctAnswer);
    }
}
