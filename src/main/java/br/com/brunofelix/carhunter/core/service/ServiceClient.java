package br.com.brunofelix.carhunter.core.service;

import br.com.brunofelix.carhunter.core.domain.request.RequestDto;
import br.com.brunofelix.carhunter.core.domain.response.ResponseDto;

import java.util.List;

public interface ServiceClient {
    List<ResponseDto> find(RequestDto requestDto);
}
