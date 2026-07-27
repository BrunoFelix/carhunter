package br.com.brunofelix.carhunter.dataprovider.client.via1.dto;

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
public class Via1Dto {

    @JsonProperty(value = "total")
    public Integer total;

    @JsonProperty(value = "total_pages")
    private Integer totalPages;

    @JsonProperty(value = "last_page")
    private boolean lastPage;

    @JsonProperty(value = "entries")
    @Builder.Default
    private List<Via1CarDto> cars = new ArrayList<>();

}
