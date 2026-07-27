package br.com.brunofelix.carhunter.dataprovider.client.autoParvi;

import br.com.brunofelix.carhunter.dataprovider.client.autoParvi.dto.AutoParviDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "autoparvi", url = "${autoparvi.client.url}")
public interface AutoParviClient {

    @GetMapping(value =
            "/?preco_de={price_start}"
                    + "&preco_ate={price_end}"
                    + "&ano_de={year_start}"
                    + "&ano_ate={year_end}"
                    + "&km_de={km_start}"
                    + "&km_ate={km_end}"
                    + "&palavra_chave="
                    + "&blindado="
                    + "&gnv="
                    + "&regiao_filtro%5B%5D={state}"
                    + "&limite=12"
                    + "&pagination={page_number}",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    AutoParviDto get(@PathVariable(value = "price_start") Integer priceStart,
                     @PathVariable(value = "price_end") Integer priceEnd,
                     @PathVariable(value = "year_start") Integer yearStart,
                     @PathVariable(value = "year_end") Integer yearEnd,
                     @PathVariable(value = "km_start") Integer kmStart,
                     @PathVariable(value = "km_end") Integer kmEnd,
                     @PathVariable(value = "state") String state,
                     @PathVariable(value = "page_number") Integer pageNumber);
}
