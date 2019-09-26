package id.co.homecredit.drools.service.impl;

import id.co.homecredit.drools.dto.EligibilityPosDto;
import id.co.homecredit.drools.factory.DroolsFactory;
import id.co.homecredit.drools.service.DroolService;
import id.co.homecredit.drools.service.EligibilityPosService;
import org.kie.api.io.Resource;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EligibilityPosServiceImpl implements EligibilityPosService {

    @Autowired
    private DroolService droolService;

    @Autowired
    private DroolsFactory droolsFactory;

    @Override
    public EligibilityPosDto getListEligibilityPosDto(EligibilityPosDto eligibilityPosDto) {
        final String path = "drools/rules/EligibilityPosDto.xls";
        final Resource resource = droolsFactory.createResource(path);
        final KieSession kieSession = droolService.getKieSession(resource);
        kieSession.insert(eligibilityPosDto);
        kieSession.fireAllRules();
        return eligibilityPosDto;
    }
}
