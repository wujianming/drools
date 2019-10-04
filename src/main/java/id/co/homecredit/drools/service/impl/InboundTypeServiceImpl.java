package id.co.homecredit.drools.service.impl;

import id.co.homecredit.drools.constant.DroolsConstant;
import id.co.homecredit.drools.dto.InboundTypeDto;
import id.co.homecredit.drools.service.DroolService;
import id.co.homecredit.drools.service.InboundTypeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InboundTypeServiceImpl implements InboundTypeService {

    private static final Logger log = LoggerFactory.getLogger(InboundTypeServiceImpl.class);

    @Autowired
    private DroolService droolService;

    @Override
    public InboundTypeDto getInboundTypeResponse(final String requestId, final InboundTypeDto inboundTypeDto) {
        log.info("InboundTypeServiceImpl.getInboundTypeResponse requestId : {}", requestId);
        return (InboundTypeDto) droolService.getObject(requestId, DroolsConstant.INBOUND_TYPE, inboundTypeDto);
    }

}
