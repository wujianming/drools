package id.co.homecredit.drools.service.impl;

import id.co.homecredit.drools.constant.DroolsConstant;
import id.co.homecredit.drools.dto.InboundTypeDto;
import id.co.homecredit.drools.service.DroolService;
import id.co.homecredit.drools.service.InboundTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InboundTypeServiceImpl implements InboundTypeService {

    @Autowired
    private DroolService droolService;

    @Override
    public InboundTypeDto getInboundTypeResponse(InboundTypeDto inboundTypeDto) {
        return (InboundTypeDto) droolService.getObject(DroolsConstant.INBOUND_TYPE, inboundTypeDto);
    }

}
