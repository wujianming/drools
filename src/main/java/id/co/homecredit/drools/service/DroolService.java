package id.co.homecredit.drools.service;

import org.kie.api.io.Resource;
import org.kie.api.runtime.KieSession;

public interface DroolService {

    KieSession getKieSession(Resource resource);

}
