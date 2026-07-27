package br.com.brunofelix.carhunter.dataprovider.client.autoParvi.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class AutoParviDto {

    @JsonProperty(value = "TOTAL_ROWS")
    private String totalRows;

    @JsonProperty(value = "VEICULOS")
    @Builder.Default
    private List<AutoParviCarDto> cars = new ArrayList<>();
}
