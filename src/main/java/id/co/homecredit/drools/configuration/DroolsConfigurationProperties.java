package id.co.homecredit.drools.configuration;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieContainerSessionsPool;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DroolsConfigurationProperties {

    @Bean
    public KieServices kieServices(){
        return KieServices.Factory.get();
    }

    @Bean
    public KieContainer kieContainer(){
        return kieServices().newKieClasspathContainer();
    }

    @Bean
    public KieContainerSessionsPool kieContainerSessionsPool(){
        KieContainerSessionsPool pool = kieContainer().newKieSessionsPool(10);
        return pool;
    }
}
