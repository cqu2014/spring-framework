package summer.nj;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import summer.nj.config.SummerConfig;
import summer.nj.service.impl.PrintServiceImpl;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * @author Oliver Wang
 * @description
 * @created by IntelliJ IDEA 2018.3.3
 * @date Create at 2020/9/21
 * @since
 */
public class Application {
	public static void main(String[] args) throws Exception {
		// 使用配置类配置spring
		ApplicationContext context = new AnnotationConfigApplicationContext(SummerConfig.class);
		context.getBean(PrintServiceImpl.class).hello();

		TimeUnit.SECONDS.sleep(10);
	}
}
