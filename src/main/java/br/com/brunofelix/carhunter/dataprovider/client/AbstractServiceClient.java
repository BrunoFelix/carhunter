package br.com.brunofelix.carhunter.dataprovider.client;

import br.com.brunofelix.carhunter.core.domain.request.RequestDto;
import br.com.brunofelix.carhunter.core.domain.response.ResponseDto;
import br.com.brunofelix.carhunter.core.service.ServiceClient;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public abstract class AbstractServiceClient implements ServiceClient {

    protected abstract String getServiceName();

    protected abstract List<ResponseDto> executeSearch(RequestDto requestDto);

    @Override
    public List<ResponseDto> find(RequestDto requestDto) {
        String serviceName = getServiceName();
        log.info("Searching on {}...", serviceName);
        try {
            List<ResponseDto> results = executeSearch(requestDto);
            log.info("Finishing on {}...", serviceName);
            return results != null ? results : List.of();
        } catch (Exception e) {
            log.error("Error on searching {}...", serviceName, e);
            return List.of();
        }
    }
}
