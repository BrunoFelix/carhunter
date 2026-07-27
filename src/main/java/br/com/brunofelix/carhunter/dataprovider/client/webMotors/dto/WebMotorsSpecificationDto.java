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
public class WebMotorsSpecificationDto {

    @JsonProperty(value = "Title")
    private String title;

    @JsonProperty(value = "Make")
    private WebMotorsItemDto make;

    @JsonProperty(value = "Model")
    private WebMotorsItemDto model;

    @JsonProperty(value = "Version")
    private WebMotorsItemDto version;

    @JsonProperty(value = "YearModel")
    private int yearModel;

    @JsonProperty(value = "Odometer")
    private int km;

    @JsonProperty(value = "Transmission")
    private String transmission;
}
