package id.co.homecredit.drools.controller;

import id.co.homecredit.drools.dto.EligibilityPosDto;
import id.co.homecredit.drools.dto.InboundTypeDto;
import id.co.homecredit.drools.service.EligibilityPosService;
import id.co.homecredit.drools.service.InboundTypeService;
import org.apache.commons.lang3.RandomStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
public class inquiryController {

    private static final Logger log = LoggerFactory.getLogger(inquiryController.class);

    @Autowired
    private InboundTypeService service;

    @Autowired
    private EligibilityPosService eligibilityPosService;

    @GetMapping(value = "${api.inquiry.v1}", produces = "application/json")
    public ResponseEntity<Object> checkResponseActiveStatus(@PathVariable("type") String type) {
        String requestId = RandomStringUtils.randomAlphanumeric(10);
        log.info("inquiryController.checkResponseActiveStatus requestId : {}, type : {}", requestId, type);
        InboundTypeDto inboundTypeDto = new InboundTypeDto();
        inboundTypeDto.setType(inboundTypeDto.findType(type));
        final InboundTypeDto responseDto = service.getInboundTypeResponse(requestId, inboundTypeDto);
        log.info("inquiryController.checkResponseActiveStatus response requestId : {}, responseDto : {}", requestId, responseDto);
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }

    @PostMapping(value = "${api.check-eligibility-pos.v1}", produces = "application/json")
    public ResponseEntity<Object> checkEligibilityPos(@RequestBody EligibilityPosDto dto) {
        log.info("inquiryController.checkEligibilityPos requestId : {}, EligibilityPosDto : {}", dto.getRequestId(), dto);
        dto.setMaxAgeTenor();
        dto.setCreatedDate(new Date());
        EligibilityPosDto eligibilityPosDto = eligibilityPosService.getAllEligibilityPosDto(dto.getRequestId(), dto);
        log.info("inquiryController.checkEligibilityPos success requestId : {}, EligibilityPosDto : {}", dto.getRequestId(), eligibilityPosDto);
        return new ResponseEntity<>(eligibilityPosDto, HttpStatus.OK);
    }

}
