package br.com.brunofelix.carhunter.dataprovider.client.olx.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class OlxDto {

    @JsonProperty(value = "pageProps")
    private OlxPagePropsDto pageProps;
}
