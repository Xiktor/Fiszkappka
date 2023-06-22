package pl.ww.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.ww.spring.api.dto.LanguageDTO;
import pl.ww.spring.api.mapper.LanguageMapper;
import pl.ww.spring.exception.NoLanguagesException;
import pl.ww.spring.exception.NotFoundException;
import pl.ww.spring.model.Language;
import pl.ww.spring.service.LanguageService;

import javax.validation.Valid;

@Controller
@RequestMapping("/language")
public class LanguageController {

    private final LanguageService languageService;

    private final LanguageMapper languageMapper;

    public LanguageController(LanguageService languageService, LanguageMapper languageMapper) {
        this.languageService = languageService;
        this.languageMapper = languageMapper;
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute(
                "listLanguages",
                languageMapper.map(
                        languageService.listAll()
                )
        );
        return "language/index";
    }

    @RequestMapping("/new")
    public String create(Model model) {
        model.addAttribute("language", new LanguageDTO());
        return "language/new";
    }

    @PostMapping("/save")
    public String saveLanguage(
            @Valid @ModelAttribute("language") LanguageDTO languageDTO,
            BindingResult bindingResult
    ) {
        if (bindingResult.hasErrors()) {
            if (languageDTO.getId() == null) {
                return "language/new";
            }
            return "language/edit";
        }
        languageService.save(
                languageMapper.languageDTOToLanguage(
                        languageDTO
                )
        );
        return "redirect:/language/";
    }

    @RequestMapping("/edit/{id}")
    public String edit(@PathVariable(name = "id") int id, Model model) throws NotFoundException {
        Language language = languageService.find(id);
        if (language == null) {
            throw new NotFoundException("nie znaleziono języka");
        }
        model.addAttribute(
                "language",
                languageMapper.languageToLanguageDTO(
                        language
                )
        );
        return "language/edit";
    }

    @RequestMapping("/delete/{id}")
    public String deleteLanguage(@PathVariable(name = "id") int id) {
        languageService.delete(id);
        return "redirect:/language/";
    }

    @RequestMapping("/select")
    public String select(Model model) throws NoLanguagesException {
        Iterable<Language> languages = languageService.listAll();
        if (languages == null) {
            throw new NoLanguagesException("nie ma żadnego języka w bazie");
        }
        model.addAttribute("language", new LanguageDTO());
        model.addAttribute("languages", languageMapper.map(languages));

        return "test/selectLanguage";
    }
}
