package summer.nj;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import summer.nj.config.SummerConfig;
import summer.nj.service.impl.PrintServiceImpl;

/**
 * @author Oliver Wang
 * @description
 * @created by IntelliJ IDEA 2018.3.3
 * @date Create at 2020/9/21
 * @since
 */
public class Application {
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(SummerConfig.class);
		context.getBean(PrintServiceImpl.class).hello();
	}
}
