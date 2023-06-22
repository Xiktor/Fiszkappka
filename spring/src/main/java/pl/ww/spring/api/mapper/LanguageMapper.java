package pl.ww.spring.api.mapper;

import org.mapstruct.*;
import pl.ww.spring.api.dto.LanguageDTO;
import pl.ww.spring.model.Language;

import java.util.List;

@Mapper(componentModel = "spring")
public interface LanguageMapper {
    @Mappings({
            @Mapping(target="id", source="entity.id"),
            @Mapping(target="name", source="entity.name"),
    })
    LanguageDTO languageToLanguageDTO(Language entity);

    @Mappings({
            @Mapping(target="id", source="dto.id"),
            @Mapping(target="name", source="dto.name"),
    })
    Language languageDTOToLanguage(LanguageDTO dto);

    Language languageDTOToLanguage(LanguageDTO dto, @MappingTarget Language language);

    List<LanguageDTO> map(Iterable<Language> languages);
}
