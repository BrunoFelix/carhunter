package br.com.brunofelix.carhunter.dataprovider.client.autoLine;

import br.com.brunofelix.carhunter.dataprovider.client.autoLine.dto.AutoLineDto;
import br.com.brunofelix.carhunter.dataprovider.client.autoLine.dto.PayloadDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "autoline", url = "${autoline.client.url}")
public interface AutoLineClient {

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    AutoLineDto get(@RequestBody PayloadDto payloadDto);
}
