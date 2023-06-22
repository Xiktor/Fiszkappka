package pl.ww.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.ww.spring.api.dto.FicheDTO;
import pl.ww.spring.api.mapper.FicheMapper;
import pl.ww.spring.api.mapper.LanguageMapper;
import pl.ww.spring.exception.NoFichesException;
import pl.ww.spring.exception.NoLanguagesException;
import pl.ww.spring.exception.NotFoundException;
import pl.ww.spring.model.Fiche;
import pl.ww.spring.model.Language;
import pl.ww.spring.service.FicheService;
import pl.ww.spring.service.LanguageService;

import javax.validation.Valid;

@Controller
@RequestMapping("/fiche")
public class FicheController {

    private final FicheService ficheService;
    private final LanguageService languageService;

    private final FicheMapper ficheMapper;
    private final LanguageMapper languageMapper;

    public FicheController(
            FicheService ficheService,
            LanguageService languageService,
            FicheMapper ficheMapper,
            LanguageMapper languageMapper
    ) {
        this.ficheService = ficheService;
        this.languageService = languageService;
        this.ficheMapper = ficheMapper;
        this.languageMapper = languageMapper;
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute(
                "listFiches",
                ficheMapper.map(
                        ficheService.listAll()
                )
        );
        return "fiche/index";
    }

    @RequestMapping("/new")
    public String create(Model model) {
        model.addAttribute("fiche", new FicheDTO());
        model.addAttribute(
                "languages",
                languageMapper.map(
                        languageService.listAll()
                )
        );
        return "fiche/new";
    }

    @PostMapping("/save")
    public String saveFiche(
            @Valid @ModelAttribute("fiche") FicheDTO ficheDTO,
            BindingResult bindingResult
    ) {
        if (bindingResult.hasErrors()) {
            if (ficheDTO.getId() == null) {
                return "fiche/new";
            }
            return "fiche/edit";
        }
        ficheService.save(
                ficheMapper.ficheDTOToFiche(
                        ficheDTO
                )
        );
        return "redirect:/fiche/";
    }

    @RequestMapping("/edit/{id}")
    public String edit(@PathVariable(name = "id") int id, Model model) throws NotFoundException, NoLanguagesException {
        Fiche fiche = ficheService.find(id);
        if (fiche == null) {
            throw new NotFoundException("nie znaleziono żadnej fiszki");
        }
        Iterable<Language> languages = languageService.listAll();
        if (languages == null) {
            throw new NoLanguagesException("nie znaleziono żadnego języka");
        }
        model.addAttribute("fiche", ficheMapper.ficheToFicheDTO(fiche));
        model.addAttribute("languages", languageMapper.map(languageService.listAll()));

        return "fiche/edit";
    }

    @RequestMapping("/delete/{id}")
    public String deleteFiche(@PathVariable(name = "id") int id) {
        ficheService.delete(id);
        return "redirect:/fiche/";
    }

    @RequestMapping("/solve")
    public String getRandomFiche(Model model) throws NoFichesException {
        model.addAttribute(
                "fiche",
                ficheMapper.ficheToFicheDTO(
                        ficheService.getRandomFiche()
                ));

        return "fiche/solve";
    }

    @RequestMapping("/checkout")
    public String checkout(
            @Valid @ModelAttribute("fiche") FicheDTO ficheDTO,
            BindingResult bindingResult
    ) {
        if (bindingResult.hasErrors()) {
            return "fiche/solve";
        }
        boolean result = ficheService.checkout(
                ficheDTO.getId(),
                ficheDTO.getWordInForeignLanguage()
        );

        if (result)
            return "fiche/resultCorrect.html";
        return "fiche/resultIncorrect.html";
    }
}
