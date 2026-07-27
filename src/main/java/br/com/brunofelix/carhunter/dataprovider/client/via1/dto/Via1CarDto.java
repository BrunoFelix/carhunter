package br.com.brunofelix.carhunter.dataprovider.client.via1.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class Via1CarDto {

    @JsonProperty(value = "id")
    private String id;

    @JsonProperty(value = "name")
    private String name;

    @JsonProperty(value = "brand")
    private String brand;

    @JsonProperty(value = "model")
    private String model;

    @JsonProperty(value = "model_year")
    private String year;

    @JsonProperty(value = "price_value")
    private String price;

    @JsonProperty(value = "km")
    private String km;

    @JsonProperty(value = "exchange")
    private String transmission;

    @JsonProperty(value = "slug")
    private String slug;

    @JsonProperty(value = "profile_image")
    private Via1PictureDto picture;

    @JsonProperty(value = "created_at")
    private String createdAt;

    @JsonProperty(value = "updated_at")
    private String updatedAt;

    @JsonProperty(value = "version")
    private String version;
}
