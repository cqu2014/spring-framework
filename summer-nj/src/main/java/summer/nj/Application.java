package summer.nj;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import summer.nj.config.SummerConfig;
import summer.nj.extend.LifecycleBean;
import summer.nj.service.impl.PrintServiceImpl;
import summer.nj.util.SpringContextUtil;

/**
 * @author Oliver Wang
 * @description
 * @created by IntelliJ IDEA 2018.3.3
 * @date Create at 2020/9/21
 * @since
 */
public class Application {
	public static void main(String[] args) {
		// 使用配置类配置spring
		ApplicationContext context = new AnnotationConfigApplicationContext(SummerConfig.class);
		context.getBean(PrintServiceImpl.class).hello();
		System.out.println(context.getBean(LifecycleBean.class).getBeanName());
		System.gc();

		System.out.println("***********************SpringContextUtil*******************************");
		// 在此处将 applicationContext 赋值保存到非spring bean的类SpringContextUtil中
		SpringContextUtil.setApplicationContext(context);
		SpringContextUtil.getBean(PrintServiceImpl.class).hello(" ApplicationContextAware ");

		System.out.println("***********************AnimalFactoryBean(Tiger)*******************************");
		System.out.println(context.getBean("animal").getClass());
	}
}
