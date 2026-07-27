package br.com.brunofelix.carhunter.dataprovider.client.webMotors.dto;

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
public class WebMotorsItemDto {

    @JsonProperty(value = "id")
    private String id;

    @JsonProperty(value = "Value")
    private String value;
}
