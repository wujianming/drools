package id.co.homecredit.drools.controller;

import id.co.homecredit.drools.dto.EligibilityPosDto;
import id.co.homecredit.drools.dto.InboundTypeDto;
import id.co.homecredit.drools.service.AgreementPosService;
import id.co.homecredit.drools.service.EligibilityPosService;
import id.co.homecredit.drools.service.InboundTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
public class inquiryController {

    @Autowired
    private InboundTypeService service;

    @Autowired
    private EligibilityPosService eligibilityPosService;

    @Autowired
    private AgreementPosService agreementPosService;

    @GetMapping(value = "${api.inquiry.v1}", produces = "application/json")
    public ResponseEntity<Object> checkResponseActiveStatus(@PathVariable("type") String type) {
        InboundTypeDto inboundTypeDto = new InboundTypeDto();
        inboundTypeDto.setType(inboundTypeDto.findType(type));
        final InboundTypeDto responseDto = service.getInboundTypeResponse(inboundTypeDto);
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }

    @PostMapping(value = "${api.check-eligibility-pos.v1}", produces = "application/json")
    public ResponseEntity<Object> checkEligibilityPos(@RequestBody EligibilityPosDto dto) {
        dto.setMaxAgeTenor();
        dto.setCreatedDate(new Date());
        EligibilityPosDto eligibilityPosDto = eligibilityPosService.getListEligibilityPosDto(dto);
        eligibilityPosDto = agreementPosService.getListAgreementReject(eligibilityPosDto);
        if (!eligibilityPosDto.getIdAgreementReject().isEmpty()) {
            eligibilityPosDto = agreementPosService.getReasonRejectMinimumDp(eligibilityPosDto);
            eligibilityPosDto = agreementPosService.getReasonRejectAge(eligibilityPosDto);
        }
        return new ResponseEntity<>(eligibilityPosDto, HttpStatus.OK);
    }

}
