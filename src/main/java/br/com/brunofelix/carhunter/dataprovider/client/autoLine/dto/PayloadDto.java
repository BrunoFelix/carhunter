package br.com.brunofelix.carhunter.dataprovider.client.autoLine.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PayloadDto {

    @JsonProperty(value = "pageSize")
    @Builder.Default
    private Integer pageSize = 999;

    @JsonProperty(value = "page")
    @Builder.Default
    private Integer page = 1;

    @JsonProperty(value = "stateId")
    @Builder.Default
    private Integer stateId = 17;

    @JsonProperty(value = "cityId")
    @Builder.Default
    private Integer cityId = 2916;

    @JsonProperty(value = "zeroKm")
    @Builder.Default
    private boolean zeroKm = false;

    @JsonProperty(value = "used")
    @Builder.Default
    private boolean used = false;

    @JsonProperty(value = "startModelYear")
    @Builder.Default
    private Integer startModelYear = 2015;

    @JsonProperty(value = "endModelYear")
    @Builder.Default
    private Integer endModelYear = 2023;

    @JsonProperty(value = "sortBy")
    @Builder.Default
    private Integer sortBy = 9;

    @JsonProperty(value = "segment")
    @Builder.Default
    private Integer segment = 1;

    @JsonProperty(value = "stateName")
    @Builder.Default
    private String stateName = "PE";

    @JsonProperty(value = "cityName")
    @Builder.Default
    private String cityName = "Recife";

    @JsonProperty(value = "maxKm")
    @Builder.Default
    private Integer maxKm = 45000;

    @JsonProperty(value = "endPrice")
    @Builder.Default
    private Integer endPrice = 90000;

    @JsonProperty(value = "isSwapNotAccepted")
    @Builder.Default
    private boolean isSwapNotAccepted = true;
}
