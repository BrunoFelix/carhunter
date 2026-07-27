package br.com.brunofelix.carhunter.dataprovider.client.olx.dto;

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
public class OlxCarDto {

    @JsonProperty(value = "title")
    private String title;

    @JsonProperty(value = "price")
    private String price;

    @JsonProperty(value = "thumbnail")
    private String thumbnail;

    @JsonProperty(value = "url")
    private String url;

    @JsonProperty(value = "location")
    private String location;

    @JsonProperty(value = "properties")
    @Builder.Default
    private List<OlxPropertiesDto> properties = new ArrayList<>();

    @JsonProperty(value = "trackingSpecificData")
    @Builder.Default
    private List<OlxTrackingSpecificDataDto> trackingSpecificData = new ArrayList<>();


 }
