package id.co.homecredit.drools.service.impl;

import id.co.homecredit.drools.factory.DroolsFactory;
import id.co.homecredit.drools.service.DroolService;
import org.kie.api.KieServices;
import org.kie.api.builder.*;
import org.kie.api.io.Resource;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieContainerSessionsPool;
import org.kie.api.runtime.KieSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class DroolServiceImpl implements DroolService {

    private static final Logger log = LoggerFactory.getLogger(InboundTypeServiceImpl.class);

    @Autowired
    private DroolsFactory droolsFactory;

    @Override
    public KieSession getKieSession(final String requestId, final Resource resource) {
        log.info("DroolServiceImpl.getKieSession requestId : {}, resource : {}", requestId, resource.getSourcePath());
        KieServices kieServices = KieServices.Factory.get();
        KieFileSystem kieFileSystem = kieServices.newKieFileSystem().write(resource);
        KieBuilder kieBuilder = kieServices.newKieBuilder(kieFileSystem).buildAll();
        Results results = kieBuilder.getResults();
        if (results.hasMessages(Message.Level.ERROR)) {
            log.error("DroolServiceImpl.getKieSession error requestId : {}, resource : {}, errorMessage : {}", requestId, resource.getSourcePath(), results.getMessages());
            throw new IllegalStateException("DroolServiceImpl.getKieSession error ".concat(results.getMessages().toString()).concat(", resource : ").concat(resource.getSourcePath()));
        }
        KieRepository kieRepository = kieServices.getRepository();
        ReleaseId krDefaultReleaseId = kieRepository.getDefaultReleaseId();
        KieContainer kieContainer = kieServices.newKieContainer(krDefaultReleaseId);
        KieContainerSessionsPool kieContainerSessionsPool = kieContainer.newKieSessionsPool(10);
        KieSession ksession = kieContainerSessionsPool.newKieSession();
        log.info("DroolServiceImpl.getKieSession success requestId : {}, resource : {}", requestId, resource.getSourcePath());
        return ksession;
    }

    @Override
    public KieSession getKieSessionListResource(final String requestId, final List<Resource> list) {
        log.info("DroolServiceImpl.getKieSessionListResource requestId : {}, resource : {}", requestId, list);
        KieServices kieServices = KieServices.Factory.get();
        KieFileSystem kieFileSystem = kieServices.newKieFileSystem();
        list.forEach(o -> {
            kieFileSystem.write(o);
        });
        KieBuilder kieBuilder = kieServices.newKieBuilder(kieFileSystem).buildAll();
        Results results = kieBuilder.getResults();
        if (results.hasMessages(Message.Level.ERROR)) {
            log.error("DroolServiceImpl.getKieSessionListResource error requestId : {}, resource : {}, errorMessage : {}", requestId, list, results.getMessages());
            throw new IllegalStateException("DroolServiceImpl.getKieSessionListResource error ".concat(results.getMessages().toString()));
        }
        KieRepository kieRepository = kieServices.getRepository();
        ReleaseId krDefaultReleaseId = kieRepository.getDefaultReleaseId();
        KieContainer kieContainer = kieServices.newKieContainer(krDefaultReleaseId);
        KieContainerSessionsPool kieContainerSessionsPool = kieContainer.newKieSessionsPool(10);
        KieSession ksession = kieContainerSessionsPool.newKieSession();
        log.info("DroolServiceImpl.getKieSessionListResource success requestId : {}, resource : {}", requestId, list);
        return ksession;
    }

    @Override
    public Object getObject(final String requestId, final String path, final Object object) {
        log.info("DroolServiceImpl.getObject requestId : {}, resource : {}, object : {}", requestId, path, object);
        final Resource resource = droolsFactory.createResource(requestId, path);
        final KieSession kieSession = this.getKieSession(requestId, resource);
        kieSession.insert(object);
        kieSession.fireAllRules();
        kieSession.dispose();
        log.info("DroolServiceImpl.getObject success requestId : {}, resource : {}, object : {}", requestId, path, object);
        return object;
    }

    @Override
    public Object getObjectExecuteSomeRules(final String requestId, final List<String> path, final Object object) {
        log.info("DroolServiceImpl.getObjectExecuteSomeRules requestId : {}, resource : {}, object : {}", requestId, path, object);
        List<Resource> listResource = droolsFactory.createListResource(requestId, path);
        final KieSession kieSession = this.getKieSessionListResource(requestId, listResource);
        kieSession.insert(object);
        kieSession.fireAllRules();
        kieSession.dispose();
        log.info("DroolServiceImpl.getObjectExecuteSomeRules success requestId : {}, resource : {}, object : {}", requestId, path, object);
        return object;
    }


}
