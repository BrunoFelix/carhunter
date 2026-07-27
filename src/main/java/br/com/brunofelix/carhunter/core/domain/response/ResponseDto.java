package br.com.brunofelix.carhunter.core.domain.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ResponseDto {

    @Builder.Default
    private Integer km = 0;
    @Builder.Default
    private Integer year = 0;
    @Builder.Default
    private Integer price = 0;
    @Builder.Default
    private String brand = "";
    @Builder.Default
    private String model = "";
    @Builder.Default
    private String version = "";
    @Builder.Default
    private String transmission = "";
    @Builder.Default
    private String information = "";
    @Builder.Default
    private String owner = "";
    @Builder.Default
    private String url = "";

}
