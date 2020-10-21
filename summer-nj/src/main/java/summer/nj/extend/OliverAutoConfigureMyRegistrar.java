package summer.nj.extend;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.util.MultiValueMap;

import javax.annotation.Nonnull;
import java.util.Map;

/**
 * @author Oliver Wang
 * @description
 * @created by IntelliJ IDEA 2020.02
 * @date Create at 2020/10/21
 * @since
 */
public class OliverAutoConfigureMyRegistrar implements ImportBeanDefinitionRegistrar,
		ResourceLoaderAware, BeanFactoryAware {
	// 保存spring context 中的信息
	private BeanFactory beanFactory;
	private ResourceLoader resourceLoader;

	@Override
	public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
		// 获取扫表的包
		Map<String, Object> attributes = importingClassMetadata.getAnnotationAttributes(ComponentScan.class.getName());
		String[] basePackages = (String[]) attributes.get("basePackages");

		// 设置扫描器并扫描类
		MyClassPathBeanDefinitionScanner scanner = new MyClassPathBeanDefinitionScanner(registry, false);
		scanner.setResourceLoader(resourceLoader);
		scanner.registerDefaultFilters();

		scanner.doScan(basePackages);
	}

	@Override
	public void setBeanFactory(@Nonnull BeanFactory beanFactory) throws BeansException {
		this.beanFactory = beanFactory;
	}

	@Override
	public void setResourceLoader(@Nonnull ResourceLoader resourceLoader) {
		this.resourceLoader = resourceLoader;
	}

	public BeanFactory getBeanFactory() {
		return beanFactory;
	}

	public ResourceLoader getResourceLoader() {
		return resourceLoader;
	}
}
