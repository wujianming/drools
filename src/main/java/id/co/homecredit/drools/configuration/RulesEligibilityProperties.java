package id.co.homecredit.drools.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@ConfigurationProperties(prefix = "drools.rules.eligibility")
public class RulesEligibilityProperties {

    private List<String> pos;

    public List<String> getPos() {
        return pos;
    }

    public void setPos(List<String> pos) {
        this.pos = pos;
    }

    @Override
    public String toString() {
        return "RulesEligibilityProperties{" +
                "pos=" + pos +
                '}';
    }
}
