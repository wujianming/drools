package id.co.homecredit.drools.service;

import id.co.homecredit.drools.dto.InboundTypeDto;

public interface InboundTypeService {

    InboundTypeDto getInboundTypeResponse(String requestId,InboundTypeDto inboundTypeDto);

}
