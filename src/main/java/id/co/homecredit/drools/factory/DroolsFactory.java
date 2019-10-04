package id.co.homecredit.drools.factory;

import id.co.homecredit.drools.dto.EligibilityPosDto;
import id.co.homecredit.drools.dto.RejectReasonDto;
import org.kie.api.io.Resource;
import org.kie.internal.io.ResourceFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class DroolsFactory {

    private static final Logger log = LoggerFactory.getLogger(DroolsFactory.class);

    public Resource createResource(final String requestId, final String path) {
        log.info("DroolsFactory.createResource requestId : {}, path : {}", requestId, path);
        final Resource resource = ResourceFactory.newClassPathResource(path, getClass());
        log.info("DroolsFactory.createResource success requestId : {}, size : {}", requestId, resource.getSourcePath());
        return resource;
    }

    public List<Resource> createListResource(final String requestId, List<String> path) {
        log.info("DroolsFactory.createListResource requestId : {}, path : {}", requestId, path);
        List<Resource> list = new ArrayList<>();
        path.forEach(o -> {
            final Resource resource = ResourceFactory.newClassPathResource(o, getClass());
            list.add(resource);
        });
        log.info("DroolsFactory.createListResource success requestId : {}, size : {}", requestId, list.size());
        return list;
    }

    public EligibilityPosDto setEligibilityPosDto(final EligibilityPosDto eligibilityPosDto, final String idAgreement) {
        eligibilityPosDto.getIdAgreement().add(idAgreement);
        return eligibilityPosDto;
    }

    public EligibilityPosDto setEligibilityPosDtoReason(final EligibilityPosDto eligibilityPosDto, final String idAgreement, final String reason) {
        Optional<RejectReasonDto> response = eligibilityPosDto.getRejectReason().stream().filter(obj -> obj.getIdAgreementReject().equals(idAgreement)).findFirst();
        if (response.isPresent()) {
            RejectReasonDto rejectReasonDto = response.get();
            rejectReasonDto.getListReason().add(reason);
        } else {
            final RejectReasonDto rejectReasonDto = new RejectReasonDto();
            rejectReasonDto.setIdAgreementReject(idAgreement);
            rejectReasonDto.getListReason().add(reason);
            eligibilityPosDto.getRejectReason().add(rejectReasonDto);
        }
        return eligibilityPosDto;
    }

}
