package br.com.brunofelix.carhunter.dataprovider.client.webMotors;

import br.com.brunofelix.carhunter.dataprovider.client.config.FeignClientWebMotorsConfig;
import br.com.brunofelix.carhunter.dataprovider.client.webMotors.dto.WebMotorsDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "webmotors", url = "${webmotors.client.url}", configuration = FeignClientWebMotorsConfig.class)
public interface WebMotorsClient {

    @GetMapping(value = "?url=https://www.webmotors.com.br/carros-usados/pe/de.2015" +
            "?estadocidade=Pernambuco" +
            "%26tipoveiculo=carros-usados" +
            "%26precode={price_start}" +
            "%26precoate={price_end}" +
            "%26anode={year_start}" +
            "%26anoate={year_end}" +
            "%26kmde={km_start}" +
            "%26kmate={km_end}" +
            "%26anunciante=Loja%257CConcession%25C3%25A1ria" +
            "%26atributos=Aceita%2520troca" +
            "%26cambio=CVT%257CAutom%25C3%25A1tica" +
            "&actualPage={page_number}" +
            "&displayPerPage=24" +
            "&order=1" +
            "&showMenu=false" +
            "&showCount=true" +
            "&showBreadCrumb=false" +
            "&testAB=false" +
            "&returnUrl=false",
            produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    WebMotorsDto get(@PathVariable(value = "price_start") Integer priceStart,
                     @PathVariable(value = "price_end") Integer priceEnd,
                     @PathVariable(value = "year_start") Integer yearStart,
                     @PathVariable(value = "year_end") Integer yearEnd,
                     @PathVariable(value = "km_start") Integer kmStart,
                     @PathVariable(value = "km_end") Integer kmEnd,
                     @PathVariable(value = "page_number") Integer pageNumber);
}
