package br.com.brunofelix.carhunter.core.domain.request;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class RequestDto {
    private Integer kmStart;
    private Integer kmEnd;
    private Integer yearStart;
    private Integer yearEnd;
    private Integer priceStart;
    private Integer priceEnd;
}
