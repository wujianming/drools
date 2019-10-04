package id.co.homecredit.drools.service;

import id.co.homecredit.drools.dto.EligibilityPosDto;

public interface EligibilityPosService {

    EligibilityPosDto getEligibilityPosDto(String requestId,EligibilityPosDto eligibilityPosDto);

    EligibilityPosDto getAllEligibilityPosDto(String requestId,EligibilityPosDto eligibilityPosDto);
}
