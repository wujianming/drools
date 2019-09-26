package id.co.homecredit.drools.service.impl;

import id.co.homecredit.drools.service.DroolService;
import org.kie.api.KieServices;
import org.kie.api.builder.*;
import org.kie.api.io.Resource;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.stereotype.Service;


@Service
public class DroolServiceImpl implements DroolService {

    @Override
    public KieSession getKieSession(final Resource resource) {
        KieServices kieServices = KieServices.Factory.get();
        KieFileSystem kieFileSystem = kieServices.newKieFileSystem().write(resource);
        KieBuilder kieBuilder = kieServices.newKieBuilder(kieFileSystem).buildAll();
        KieRepository kieRepository = kieServices.getRepository();
        ReleaseId krDefaultReleaseId = kieRepository.getDefaultReleaseId();
        KieContainer kieContainer = kieServices.newKieContainer(krDefaultReleaseId);
        KieSession ksession = kieContainer.newKieSession();
        return ksession;
    }

}
