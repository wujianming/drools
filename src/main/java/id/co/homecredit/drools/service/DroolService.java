package id.co.homecredit.drools.service;

import org.kie.api.io.Resource;
import org.kie.api.runtime.KieSession;

import java.util.List;

public interface DroolService {

    KieSession getKieSession(String requestId ,Resource resource);

    KieSession getKieSessionListResource(String requestId ,List<Resource> list);

    Object getObject(String requestId ,String path, Object object);

    Object getObjectExecuteSomeRules(String requestId ,List<String> path, Object object);

}
