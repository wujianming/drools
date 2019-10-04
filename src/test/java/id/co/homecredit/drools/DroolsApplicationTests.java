package id.co.homecredit.drools;

import id.co.homecredit.drools.dto.EligibilityPosDto;
import org.junit.Test;

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
