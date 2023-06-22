package pl.ww.spring.api.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Mappings;
import pl.ww.spring.api.dto.LanguageDTO;
import pl.ww.spring.api.dto.TestDTO;
import pl.ww.spring.model.Language;
import pl.ww.spring.model.Test;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TestMapper {

    @Mappings({
            @Mapping(target="id", source="entity.id"),
            @Mapping(target="score", source="entity.score"),
            @Mapping(target="resolved", source="entity.resolved"),
            @Mapping(target="languageName", source="entity.languageName"),
            @Mapping(target="question1", source="entity.question1"),
            @Mapping(target="question2", source="entity.question2"),
            @Mapping(target="question3", source="entity.question3"),
            @Mapping(target="correctAnswer1", source="entity.correctAnswer1"),
            @Mapping(target="correctAnswer2", source="entity.correctAnswer2"),
            @Mapping(target="correctAnswer3", source="entity.correctAnswer3"),
            @Mapping(target="userAnswer1", source="entity.userAnswer1"),
            @Mapping(target="userAnswer2", source="entity.userAnswer2"),
            @Mapping(target="userAnswer3", source="entity.userAnswer3"),
    })
    TestDTO testToTestDTO(Test entity);

    @Mappings({
            @Mapping(target="id", source="dto.id"),
            @Mapping(target="score", source="dto.score"),
            @Mapping(target="resolved", source="dto.resolved"),
            @Mapping(target="languageName", source="dto.languageName"),
            @Mapping(target="question1", source="dto.question1"),
            @Mapping(target="question2", source="dto.question2"),
            @Mapping(target="question3", source="dto.question3"),
            @Mapping(target="correctAnswer1", source="dto.correctAnswer1"),
            @Mapping(target="correctAnswer2", source="dto.correctAnswer2"),
            @Mapping(target="correctAnswer3", source="dto.correctAnswer3"),
            @Mapping(target="userAnswer1", source="dto.userAnswer1"),
            @Mapping(target="userAnswer2", source="dto.userAnswer2"),
            @Mapping(target="userAnswer3", source="dto.userAnswer3")
    })
    Test testDTOToTest(TestDTO dto);

    Test testDTOToTest(TestDTO dto, @MappingTarget Test test);

    List<TestDTO> map(Iterable<Test> tests);
}
