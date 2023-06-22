package pl.ww.spring.api.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Mappings;
import pl.ww.spring.api.dto.FicheDTO;
import pl.ww.spring.model.Fiche;

import java.util.List;

@Mapper(componentModel = "spring")
public interface FicheMapper {

    @Mappings({
            @Mapping(target="id", source="entity.id"),
            @Mapping(target="wordInMotherLanguage", source="entity.wordInMotherLanguage"),
            @Mapping(target="wordInForeignLanguage", source="entity.wordInForeignLanguage"),
            @Mapping(target="languageId", source="entity.language.id"),
            @Mapping(target="languageName", source="entity.language.name"),
    })
    FicheDTO ficheToFicheDTO(Fiche entity);

    @Mappings({
            @Mapping(target="id", source="dto.id"),
            @Mapping(target="wordInMotherLanguage", source="dto.wordInMotherLanguage"),
            @Mapping(target="wordInForeignLanguage", source="dto.wordInForeignLanguage"),
            @Mapping(target="language.id", source="dto.languageId"),
            @Mapping(target="language.name", source="dto.languageName"),
    })
    Fiche ficheDTOToFiche(FicheDTO dto);

    Fiche ficheDTOToFiche(FicheDTO dto, @MappingTarget Fiche fiche);

    List<FicheDTO> map(Iterable<Fiche> fiches);
}
