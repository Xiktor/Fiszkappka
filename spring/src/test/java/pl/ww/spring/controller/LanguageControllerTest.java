package pl.ww.spring.controller;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import org.assertj.core.util.Lists;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import pl.ww.spring.model.Language;
import pl.ww.spring.repository.LanguageRepository;
import pl.ww.spring.service.LanguageService;

@SpringBootTest
@AutoConfigureMockMvc
public class LanguageControllerTest {

    @MockBean
    private LanguageService service;

    @MockBean
    private LanguageRepository repository;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void index() throws Exception {
        Language language = new Language(1, "Holenderski");
        Language language2 = new Language(2, "Niemiecki");
        doReturn(Lists.newArrayList(language, language2)).when(service).listAll();

        mockMvc.perform(get("/language/"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("text/html;charset=UTF-8"))
                .andExpect(view().name("language/index"))
                .andExpect(content().string(Matchers.containsString("Holenderski")))
                .andExpect(content().string(Matchers.containsString("Niemiecki")))
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void testDeleteLanguage() throws Exception {
        when(service.find(1)).thenReturn(new Language("Angielski"));
        mockMvc.perform(get("/language/delete/{id}", 1))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/language/"))
                .andExpect(redirectedUrl("/language/"));
        verify(service, times(1)).delete(1);
    }

    @Test
    public void testSelectLanguage() throws Exception {
        when(service.listAll()).thenReturn(Lists.newArrayList(new Language("Angielski")));
        mockMvc.perform(get("/language/select"))
                .andExpect(status().isOk())
                .andExpect(view().name("test/selectLanguage"))
                .andExpect(model().attribute("languages", Matchers.hasSize(1)))
                .andExpect(model().attribute("languages", Matchers.hasItem(Matchers.hasProperty("name", Matchers.is("Angielski")))))
                .andExpect(model().attribute("language", Matchers.hasProperty("name", Matchers.isEmptyOrNullString())));
        verify(service, times(1)).listAll();
    }

}
