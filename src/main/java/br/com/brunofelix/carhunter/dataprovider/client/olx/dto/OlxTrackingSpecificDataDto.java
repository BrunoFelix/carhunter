package br.com.brunofelix.carhunter.dataprovider.client.olx.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class OlxTrackingSpecificDataDto {

    @JsonProperty(value = "key")
    private String key;

    @JsonProperty(value = "value")
    private String value;
}
