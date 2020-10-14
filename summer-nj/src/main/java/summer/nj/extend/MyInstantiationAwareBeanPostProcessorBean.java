package summer.nj.extend;

import cn.hutool.core.lang.Console;
import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessorAdapter;
import org.springframework.stereotype.Component;

import java.lang.reflect.Constructor;

/**
 * @author Oliver Wang
 * @description
 * @created by IntelliJ IDEA 2020.02
 * @date Create at 2020/10/14
 * @since
 */
@Component
public class MyInstantiationAwareBeanPostProcessorBean extends InstantiationAwareBeanPostProcessorAdapter {
	@Override
	public Class<?> predictBeanType(Class<?> beanClass, String beanName) throws BeansException {
		return super.predictBeanType(beanClass, beanName);
	}

	@Override
	public Constructor<?>[] determineCandidateConstructors(Class<?> beanClass, String beanName) throws BeansException {
		return super.determineCandidateConstructors(beanClass, beanName);
	}

	@Override
	public Object getEarlyBeanReference(Object bean, String beanName) throws BeansException {
		return super.getEarlyBeanReference(bean, beanName);
	}

	@Override
	public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
		Console.log("InstantiationAwareBeanPostProcessorAdapter BeforeInstantiation beanClass={},beanName={}",
				beanClass.getSimpleName(),beanName);
		return super.postProcessBeforeInstantiation(beanClass, beanName);
	}

	@Override
	public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
		Console.log("InstantiationAwareBeanPostProcessorAdapter BeforeInstantiation beanClass={},beanName={}",
				bean.getClass().getSimpleName(),beanName);
		return super.postProcessAfterInstantiation(bean, beanName);
	}

	@Override
	public PropertyValues postProcessProperties(PropertyValues pvs, Object bean, String beanName) throws BeansException {
		return super.postProcessProperties(pvs, bean, beanName);
	}

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		Console.log("InstantiationAwareBeanPostProcessorAdapter BeforeInstantiation beanClass={},beanName={}",
				bean.getClass().getSimpleName(),beanName);
		return super.postProcessBeforeInitialization(bean, beanName);
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		Console.log("InstantiationAwareBeanPostProcessorAdapter BeforeInstantiation beanClass={},beanName={}",
				bean.getClass().getSimpleName(),beanName);
		return super.postProcessAfterInitialization(bean, beanName);
	}
}
