package summer.nj.extend;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.filter.AssignableTypeFilter;
import summer.nj.dto.AutoRegisterBean;

import java.util.Map;

/**
 * @author Oliver Wang
 * @description Bean的动态注入
 * @created by IntelliJ IDEA 2020.02
 * @date Create at 2020/10/21
 * @since
 */
public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {
	/**
	 * importingClassMetadata 当前类的注解信息
	 * registry 注册类，将bean注入Ioc容器中
	 *
	 * @param importingClassMetadata
	 * @param registry
	 */
	@Override
	public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
		// 扫描注解
		Map<String, Object> annotationAttributes = importingClassMetadata.getAnnotationAttributes(ComponentScan.class.getName());
		// 获取需要扫表scan的包
		String[] basePackages = (String[]) annotationAttributes.get("basePackages");
		ClassPathBeanDefinitionScanner scanner = new ClassPathBeanDefinitionScanner(registry, false);
		AssignableTypeFilter typeFilter = new AssignableTypeFilter(AutoRegisterBean.class);

		scanner.addIncludeFilter(typeFilter);
		scanner.scan(basePackages);
	}
}
