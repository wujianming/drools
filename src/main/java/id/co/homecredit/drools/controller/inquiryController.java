package id.co.homecredit.drools.controller;

import id.co.homecredit.drools.dto.EligibilityPosDto;
import id.co.homecredit.drools.dto.InboundTypeDto;
import id.co.homecredit.drools.service.EligibilityPosService;
import id.co.homecredit.drools.service.InboundTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class inquiryController {

    @Autowired
    private InboundTypeService service;

    @Autowired
    private EligibilityPosService eligibilityPosService;

    @GetMapping(value = "/inquiry/{type}")
    public ResponseEntity<String> checkResponseActiveStatus(@PathVariable("type") String type) {
        InboundTypeDto inboundTypeDto = new InboundTypeDto();
        inboundTypeDto.setType(inboundTypeDto.findType(type));
        final InboundTypeDto responseDto = service.getInboundTypeResponse(inboundTypeDto);
        String response = "Status : "+responseDto.getResponse();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping(value = "/eligibility/pos", produces = "application/json")
    public ResponseEntity<Object> checkEligibility(@RequestBody EligibilityPosDto dto) {
        dto.setMaxAgeTenor();
        final EligibilityPosDto eligibilityPosDto = eligibilityPosService.getListEligibilityPosDto(dto);
        return new ResponseEntity<>(eligibilityPosDto, HttpStatus.OK);
    }

}
