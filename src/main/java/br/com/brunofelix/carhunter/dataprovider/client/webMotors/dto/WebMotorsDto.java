package br.com.brunofelix.carhunter.dataprovider.client.webMotors.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class WebMotorsDto {

    @JsonProperty(value = "SearchResults")
    @Builder.Default
    private List<WebMotorsCarDto> cars = new ArrayList<>();
}
