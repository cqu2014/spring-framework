package summer.nj.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;

import java.util.Objects;

/**
 * @author Oliver Wang
 * @description
 * @created by IntelliJ IDEA 2020.02
 * @date Create at 2020/10/12
 * @since
 */
public class SpringContextUtil {
	private static ApplicationContext applicationContext;

	public static void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		System.out.println("set ContextUtil applicationContext= " + applicationContext.getDisplayName());
		SpringContextUtil.applicationContext = applicationContext;
	}

	public static ApplicationContext getApplicationContext() {
		checkApplicationContext();
		return applicationContext;
	}


	public static <T> T getBean(Class<T> clazz){
		return applicationContext.getBean(clazz);
	}

	/**
	 * 检验applicationContext是否注入成功
	 */
	private static void checkApplicationContext()
	{
		if (Objects.isNull(applicationContext)){
			throw new IllegalStateException("applicationContext未注入");
		}
	}
}
