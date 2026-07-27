package br.com.brunofelix.carhunter.dataprovider.client.webMotors.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class WebMotorsCarDto {

    @JsonProperty(value = "UniqueId")
    private String id;

    @JsonProperty(value = "Specification")
    private WebMotorsSpecificationDto specification;

    @JsonProperty(value = "Prices")
    private WebMotorsPriceDto price;

    @JsonProperty(value = "FipePercent")
    private int fipePercent;
 }
