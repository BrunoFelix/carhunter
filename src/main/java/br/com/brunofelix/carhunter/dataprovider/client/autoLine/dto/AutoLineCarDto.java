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
public class AutoLineCarDto {

    @JsonProperty(value = "AdId")
    private Integer id;

    @JsonProperty(value = "MakeName")
    private String makeName;

    @JsonProperty(value = "ModelName")
    private String modelName;

    @JsonProperty(value = "ModelYear")
    private String modelYear;

    @JsonProperty(value = "Km")
    private Integer km;

    @JsonProperty(value = "Price")
    private String price;

    @JsonProperty(value = "TransmissionName")
    private String transmission;

    @JsonProperty(value = "Images")
    @Builder.Default
    private List<AutoLineImageDto> images = new ArrayList<>();

    @JsonProperty(value = "RegisterDate")
    private String registerDate;

    @JsonProperty(value = "DataAtualizacao")
    private String dataAtualizacao;

    @JsonProperty(value = "VersionName")
    private String versionName;

    @JsonProperty(value = "LinkAnuncio")
    private String linkAnuncio;

    @JsonProperty(value = "AdditionalInformation")
    private String additionalInformation;

}
