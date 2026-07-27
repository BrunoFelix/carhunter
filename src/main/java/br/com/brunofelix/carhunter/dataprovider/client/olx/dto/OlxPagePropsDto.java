package br.com.brunofelix.carhunter.dataprovider.client.olx.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class OlxPagePropsDto {

    @JsonProperty(value = "totalOfAds")
    private Integer total;

    @JsonProperty(value = "ads")
    private List<OlxCarDto> cars;
}
