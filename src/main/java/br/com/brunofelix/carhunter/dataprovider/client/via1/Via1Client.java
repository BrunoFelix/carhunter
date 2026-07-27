package br.com.brunofelix.carhunter.dataprovider.client.via1;

import br.com.brunofelix.carhunter.dataprovider.client.config.FeignClientVia1Config;
import br.com.brunofelix.carhunter.dataprovider.client.via1.dto.Via1Dto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "via1", url = "${via1.client.url}", configuration = FeignClientVia1Config.class)
public interface Via1Client {

    @GetMapping(value =
            "?q[active_eq]=true"
                    + "&q[new_vehicle_eq]=false "
                    + "&q[price_value_gteq]={price_start}"
                    + "&q[price_value_lteq]={price_end}"
                    + "&q[fabrication_year_gteq]={year_start}"
                    + "&q[fabrication_year_lteq]={year_end}"
                    + "&q[km_gteq]={km_start}"
                    + "&q[km_lteq]={km_end}"
                    + "&q[unit_id_in][]=185"
                    + "&q[unit_id_in][]=504"
                    + "&q[unit_id_in][]=1806"
                    + "&q[unit_id_in][]=1952"
                    + "&q[unit_id_in][]=1807"
                    + "&q[unit_id_in][]=2180"
                    + "&page=1"
                    + "&per_page=999"
                    + "&sort=price_value",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    Via1Dto get(@PathVariable(value = "price_start") Integer priceStart,
                @PathVariable(value = "price_end") Integer priceEnd,
                @PathVariable(value = "year_start") Integer yearStart,
                @PathVariable(value = "year_end") Integer yearEnd,
                @PathVariable(value = "km_start") Integer kmStart,
                @PathVariable(value = "km_end") Integer kmEnd);
}
