package summer.nj.extend.register;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Objects;

/**
 * @author Oliver Wang
 * @description
 * @created by IntelliJ IDEA 2020.02
 * @date Create at 2020/10/21
 * @since
 */
@Component
public class OliverAutoConfigureMyRegistrar implements ImportBeanDefinitionRegistrar,
		ResourceLoaderAware, BeanFactoryAware {
	// 保存spring context 中的信息
	private BeanFactory beanFactory;
	private ResourceLoader resourceLoader;

	@Override
	public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
		// 获取特定注解的属性信息，此处为 ComponentScan 全限定名
		Map<String, Object> attributes = importingClassMetadata.getAnnotationAttributes(ComponentScan.class.getName());
		// 从注解属性集合中获取需要扫描的basePackages
		String[] basePackages = (String[]) attributes.get("basePackages");

		// 设置扫描器并扫描类
		MyClassPathBeanDefinitionScanner scanner = new MyClassPathBeanDefinitionScanner(registry, false);
		// 设置资源加载器
		scanner.setResourceLoader(resourceLoader);
		// 增加扫表类型（注解类型）addIncludeFilter(new AnnotationTypeFilter(Oliver.class));
		scanner.registerDefaultFilters();

		scanner.doScan(basePackages);
	}

	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		this.beanFactory = beanFactory;
	}

	@Override
	public void setResourceLoader(ResourceLoader resourceLoader) {
		this.resourceLoader = resourceLoader;
	}

	public <T> T getBean(Class<T> tClass){
		if (Objects.isNull(beanFactory)){
			throw new RuntimeException("beanFactory is null");
		}
		return beanFactory.getBean(tClass);
	}
}
