package pl.ww.spring.service;


import org.springframework.stereotype.Service;
import pl.ww.spring.model.Language;
import pl.ww.spring.repository.LanguageRepository;

import javax.transaction.Transactional;

@Service
@Transactional
public class LanguageService {

    private final LanguageRepository languageRepository;

    public LanguageService(LanguageRepository languageRepository) {
        this.languageRepository = languageRepository;
    }

    public Iterable<Language> listAll() {
        return languageRepository.findAll();
    }

    public void save(Language language) {
        languageRepository.save(language);
    }

    public Language find(Integer id) {
        return languageRepository.findById(id).orElse(null);
    }

    public void delete(Integer id) {
        languageRepository.deleteById(id);
    }
}
