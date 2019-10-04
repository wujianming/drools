package id.co.homecredit.drools.service.impl;

import id.co.homecredit.drools.configuration.RulesEligibilityProperties;
import id.co.homecredit.drools.constant.DroolsConstant;
import id.co.homecredit.drools.dto.EligibilityPosDto;
import id.co.homecredit.drools.service.DroolService;
import id.co.homecredit.drools.service.EligibilityPosService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EligibilityPosServiceImpl implements EligibilityPosService {

    private static final Logger log = LoggerFactory.getLogger(EligibilityPosServiceImpl.class);

    @Autowired
    private DroolService droolService;

    @Autowired
    private RulesEligibilityProperties rulesEligibilityProperties;

    @Override
    public EligibilityPosDto getEligibilityPosDto(final String requestId,final EligibilityPosDto eligibilityPosDto) {
        log.info("EligibilityPosServiceImpl.getEligibilityPosDto requestId : {}", requestId);
        return (EligibilityPosDto) droolService.getObject(requestId, DroolsConstant.ELIGIBILITY_POS, eligibilityPosDto);
    }

    @Override
    public EligibilityPosDto getAllEligibilityPosDto(final String requestId,final EligibilityPosDto eligibilityPosDto) {
        log.info("EligibilityPosServiceImpl.getAllEligibilityPosDto requestId : {}", requestId);
        return (EligibilityPosDto) droolService.getObjectExecuteSomeRules(requestId, rulesEligibilityProperties.getPos(), eligibilityPosDto);
    }
}
