package br.com.brunofelix.carhunter.dataprovider.client.autoParvi.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class AutoParviCarDto {

    @JsonProperty(value = "ID")
    private String id;

    @JsonProperty(value = "CODIGO")
    private String code;

    @JsonProperty(value = "ANO_FABRICACAO")
    private Integer fabricationYear;

    @JsonProperty(value = "ANO_MODELO")
    private Integer year;

    @JsonProperty(value = "CAMBIO")
    private String transmission;

    @JsonProperty(value = "KM")
    private Integer km;

    @JsonProperty(value = "PRECO")
    private String price;

    @JsonProperty(value = "FOTO_INTEGRADOR")
    private String picture;

    @JsonProperty(value = "MARCA")
    private String brand;

    @JsonProperty(value = "MODELO")
    private String model;

    @JsonProperty(value = "PROPRIETARIO_TITULO")
    private String owner;

    @JsonProperty(value = "VESAO_URL")
    private String url;

    @JsonProperty(value = "VERSAO")
    private String version;

}
