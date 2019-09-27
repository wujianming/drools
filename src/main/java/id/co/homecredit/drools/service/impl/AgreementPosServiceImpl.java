package id.co.homecredit.drools.service.impl;

import id.co.homecredit.drools.dto.EligibilityPosDto;
import id.co.homecredit.drools.factory.DroolsFactory;
import id.co.homecredit.drools.service.AgreementPosService;
import id.co.homecredit.drools.service.DroolService;
import org.kie.api.io.Resource;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AgreementPosServiceImpl implements AgreementPosService {

    @Autowired
    private DroolService droolService;

    @Autowired
    private DroolsFactory droolsFactory;

    @Override
    public EligibilityPosDto getListAgreementReject(EligibilityPosDto eligibilityPosDto) {
        final String path = "drools/rules/response/pos/reject/AgreementListPos.xls";
        final Resource resource = droolsFactory.createResource(path);
        final KieSession kieSession = droolService.getKieSession(resource);
        kieSession.insert(eligibilityPosDto);
        kieSession.fireAllRules();
        return eligibilityPosDto;
    }

    @Override
    public EligibilityPosDto getReasonRejectMinimumDp(EligibilityPosDto eligibilityPosDto) {
        final String path = "drools/rules/response/pos/reject/DownPaymentReasonRejectPos.xls";
        final Resource resource = droolsFactory.createResource(path);
        final KieSession kieSession = droolService.getKieSession(resource);
        kieSession.insert(eligibilityPosDto);
        kieSession.fireAllRules();
        return eligibilityPosDto;
    }

    @Override
    public EligibilityPosDto getReasonRejectAge(EligibilityPosDto eligibilityPosDto) {
        final String path = "drools/rules/response/pos/reject/AgeReasonRejectPos.xls";
        final Resource resource = droolsFactory.createResource(path);
        final KieSession kieSession = droolService.getKieSession(resource);
        kieSession.insert(eligibilityPosDto);
        kieSession.fireAllRules();
        return eligibilityPosDto;
    }
}
