package id.co.homecredit.drools.service;

import id.co.homecredit.drools.dto.EligibilityPosDto;

public interface AgreementPosService {

    EligibilityPosDto getListAgreementReject(EligibilityPosDto eligibilityPosDto);

    EligibilityPosDto getReasonRejectMinimumDp(EligibilityPosDto eligibilityPosDto);

    EligibilityPosDto getReasonRejectAge(EligibilityPosDto eligibilityPosDto);

}
