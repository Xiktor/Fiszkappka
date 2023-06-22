package pl.ww.spring.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotEmpty;

public class LanguageDTO {

    @JsonProperty("id")
    private Integer id;

    @JsonProperty("name")
    @NotEmpty(message = "Proszę podać nazwę języka...")
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
