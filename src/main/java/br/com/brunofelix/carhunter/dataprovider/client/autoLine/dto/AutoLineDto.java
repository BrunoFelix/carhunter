package br.com.brunofelix.carhunter.dataprovider.client.autoLine.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class AutoLineDto {

    @JsonProperty(value = "PageCount")
    private Integer pageCount;

    @JsonProperty(value = "Page")
    private Integer page;

    @JsonProperty(value = "AdCount")
    private Integer adCount;

    @JsonProperty(value = "Ads")
    @Builder.Default
    private List<AutoLineCarDto> cars = new ArrayList<>();
}
