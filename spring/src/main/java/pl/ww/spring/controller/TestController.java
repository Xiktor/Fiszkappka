package pl.ww.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.ww.spring.api.dto.LanguageDTO;
import pl.ww.spring.api.dto.TestDTO;
import pl.ww.spring.api.mapper.TestMapper;
import pl.ww.spring.exception.NoLanguagesException;
import pl.ww.spring.exception.NotEnoughFichesException;
import pl.ww.spring.exception.NotFoundException;
import pl.ww.spring.model.Test;
import pl.ww.spring.service.TestService;

import javax.validation.Valid;

@Controller
@RequestMapping("/test")
public class TestController {

    private final TestService testService;
    private final TestMapper testMapper;

    public TestController(
            TestService testService,
            TestMapper testMapper
    ) {
        this.testService = testService;
        this.testMapper = testMapper;
    }

    @RequestMapping("/testStart")
    public String testStart(
            @Valid @ModelAttribute("language") LanguageDTO languageDTO,
            BindingResult bindingResult,
            Model model
    ) throws NotEnoughFichesException, NoLanguagesException {
        if (languageDTO.getId() == null) {
            throw new NoLanguagesException("nie wybrano żadnego jezyka");
        }
        Test test = testService.createNewTest(languageDTO.getId());
        model.addAttribute(
                "test",
                testMapper.testToTestDTO(test)
        );
        return "test/start";
    }

    @RequestMapping("/testEnd")
    public String testEnd(
            @Valid @ModelAttribute("test") TestDTO testDTO,
            BindingResult bindingResult,
            Model model
    ) {
        Test test= testService.checkAndReturn(testDTO);
        model.addAttribute(
                "test",
                testMapper.testToTestDTO(test)
        );

        return "test/result";
    }

    @GetMapping("/history")
    public String history(Model model) {
        model.addAttribute(
                "listTests",
                testMapper.map(
                        testService.listAll()
                )
        );
        return "test/history";
    }
}