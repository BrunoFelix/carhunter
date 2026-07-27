package br.com.brunofelix.carhunter.dataprovider.client.olx;

import br.com.brunofelix.carhunter.dataprovider.client.config.FeignClientOlxConfig;
import br.com.brunofelix.carhunter.dataprovider.client.olx.dto.OlxDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "olx", url = "${olx.client.url}", configuration = FeignClientOlxConfig.class)
public interface OlxClient {

    @GetMapping(value =
            "?f=c"
                    + "&gb=2"
                    + "&ps={price_start}"
                    + "&pe={price_end}"
                    + "&rs={year_start}"
                    + "&re={year_end}"
                    + "&ms={km_start}"
                    + "&me={km_end}"
                    + "&exc=1"
                    + "&hgnv=false"
                    + "&route=carros-vans-e-utilitarios"
                    + "&route=estado-pe"
                    + "&o={page_number}")
    OlxDto get(@PathVariable(value = "price_start") Integer priceStart,
               @PathVariable(value = "price_end") Integer priceEnd,
               @PathVariable(value = "year_start") Integer yearStart,
               @PathVariable(value = "year_end") Integer yearEnd,
               @PathVariable(value = "km_start") Integer kmStart,
               @PathVariable(value = "km_end") Integer kmEnd,
               @PathVariable(value = "page_number") Integer pageNumber);
}
