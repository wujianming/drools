package id.co.homecredit.drools.service.impl;

import id.co.homecredit.drools.constant.DroolsConstant;
import id.co.homecredit.drools.dto.EligibilityPosDto;
import id.co.homecredit.drools.service.DroolService;
import id.co.homecredit.drools.service.EligibilityPosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EligibilityPosServiceImpl implements EligibilityPosService {

    @Autowired
    private DroolService droolService;

    @Override
    public EligibilityPosDto getListEligibilityPosDto(EligibilityPosDto eligibilityPosDto) {
        return (EligibilityPosDto) droolService.getObject(DroolsConstant.ELIGIBILITY_POS, eligibilityPosDto);
    }
}
