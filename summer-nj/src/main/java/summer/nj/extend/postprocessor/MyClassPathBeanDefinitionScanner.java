package summer.nj.extend.postprocessor;

import org.springframework.beans.factory.config.BeanDefinitionHolder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;
import org.springframework.core.type.filter.AnnotationTypeFilter;
import summer.nj.annotation.Oliver;

import java.util.Set;

/**
 * @author Oliver Wang
 * @description beanDefinition 扫描器，获取我们需要祖册的bean
 * @created by IntelliJ IDEA 2020.02
 * @date Create at 2020/10/21
 * @since
 */
public class MyClassPathBeanDefinitionScanner extends ClassPathBeanDefinitionScanner {
	public MyClassPathBeanDefinitionScanner(BeanDefinitionRegistry registry, boolean useDefaultFilters) {
		super(registry, useDefaultFilters);
	}

	@Override
	protected void registerDefaultFilters() {
		addIncludeFilter(new AnnotationTypeFilter(Oliver.class));
	}

	@Override
	protected Set<BeanDefinitionHolder> doScan(String... basePackages) {
		return super.doScan(basePackages);
	}
}
