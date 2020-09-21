package summer.nj.config;

import lombok.Data;
import lombok.ToString;
import org.springframework.stereotype.Component;

/**
 * @author Oliver Wang
 * @description
 * @created by IntelliJ IDEA 2018.3.3
 * @date Create at 2020/9/21
 * @since
 */
@Data
@Component
@ToString(exclude = {"name"} )
public class LombokTest {
	private String name;
	private int age;

	static {
		LombokTest lombokTest = new LombokTest();
		lombokTest.setAge(12);
		lombokTest.setName("oliver wang");
		System.out.println(lombokTest);
	}
}
