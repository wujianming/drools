package id.co.homecredit.drools.service.impl;

import id.co.homecredit.drools.constant.DroolsConstant;
import id.co.homecredit.drools.dto.EligibilityPosDto;
import id.co.homecredit.drools.service.AgreementPosService;
import id.co.homecredit.drools.service.DroolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AgreementPosServiceImpl implements AgreementPosService {

    @Autowired
    private DroolService droolService;

    @Override
    public EligibilityPosDto getListAgreementReject(EligibilityPosDto eligibilityPosDto) {
        return (EligibilityPosDto) droolService.getObject(DroolsConstant.REJECT_BANK_LIST_POS, eligibilityPosDto);
    }

    @Override
    public EligibilityPosDto getReasonRejectMinimumDp(EligibilityPosDto eligibilityPosDto) {
        return (EligibilityPosDto) droolService.getObject(DroolsConstant.REJECT_RESPONSE_DP_POS, eligibilityPosDto);
    }

    @Override
    public EligibilityPosDto getReasonRejectAge(EligibilityPosDto eligibilityPosDto) {
        return (EligibilityPosDto) droolService.getObject(DroolsConstant.REJECT_RESPONSE_AGE_POS, eligibilityPosDto);
    }
}
