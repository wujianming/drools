package id.co.homecredit.drools;

import id.co.homecredit.drools.dto.EligibilityPosDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;


//@RunWith(SpringRunner.class)
//@SpringBootTest
public class DroolsApplicationTests {


	@Test
	public void contextLoads() {
	}

	@Test
	public void test(){
		EligibilityPosDto dto = new EligibilityPosDto();
		dto.setIdAgreement(Arrays.asList("PERMATA","BTPN"));
		System.out.println(dto.getIdAgreement().contains("DBS"));
	}

}
