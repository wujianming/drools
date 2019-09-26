package id.co.homecredit.drools.service.impl;

import id.co.homecredit.drools.dto.InboundTypeDto;
import id.co.homecredit.drools.factory.DroolsFactory;
import id.co.homecredit.drools.service.DroolService;
import id.co.homecredit.drools.service.InboundTypeService;
import org.kie.api.io.Resource;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InboundTypeServiceImpl implements InboundTypeService {

    @Autowired
    private DroolService droolService;

    @Autowired
    private DroolsFactory droolsFactory;

    @Override
    public InboundTypeDto getInboundTypeResponse(InboundTypeDto inboundTypeDto) {
        final String path = "drools/rules/InboundTypeDto.xls";
        final Resource resource = droolsFactory.createResource(path);
        final KieSession kieSession = droolService.getKieSession(resource);
        kieSession.insert(inboundTypeDto);
        kieSession.fireAllRules();
        return inboundTypeDto;
    }

}
