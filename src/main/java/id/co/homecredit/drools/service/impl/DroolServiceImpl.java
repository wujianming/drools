package id.co.homecredit.drools.service.impl;

import id.co.homecredit.drools.factory.DroolsFactory;
import id.co.homecredit.drools.service.DroolService;
import org.kie.api.KieServices;
import org.kie.api.builder.*;
import org.kie.api.io.Resource;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieContainerSessionsPool;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class DroolServiceImpl implements DroolService {

    @Autowired
    private DroolsFactory droolsFactory;

    @Override
    public KieSession getKieSession(final Resource resource) {
        KieServices kieServices = KieServices.Factory.get();
        KieFileSystem kieFileSystem = kieServices.newKieFileSystem().write(resource);
        KieBuilder kieBuilder = kieServices.newKieBuilder(kieFileSystem).buildAll();
        KieRepository kieRepository = kieServices.getRepository();
        ReleaseId krDefaultReleaseId = kieRepository.getDefaultReleaseId();
        KieContainer kieContainer = kieServices.newKieContainer(krDefaultReleaseId);
        KieContainerSessionsPool kieContainerSessionsPool = kieContainer.newKieSessionsPool(10);
        KieSession ksession = kieContainerSessionsPool.newKieSession();
        return ksession;
    }

    @Override
    public Object getObject(final String path, final Object object) {
        final Resource resource = droolsFactory.createResource(path);
        final KieSession kieSession = this.getKieSession(resource);
        kieSession.insert(object);
        kieSession.fireAllRules();
        kieSession.dispose();
        return object;
    }

}
