package id.co.homecredit.drools.factory;

import org.kie.api.io.Resource;
import org.kie.internal.io.ResourceFactory;
import org.springframework.stereotype.Component;

@Component
public class DroolsFactory {

    public Resource createResource(final String path) {
        final Resource resource = ResourceFactory.newClassPathResource(path, getClass());
        return resource;
    }

}
