package summer.nj.service.impl;

import cn.hutool.core.lang.Console;
import cn.hutool.json.JSONUtil;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

/**
 * @author Oliver Wang
 * @description BeanPostProcessor是Bean factory提供的hook函数，允许用户在bean初始化前后做个性化处理
 * @created by wang zhen 2018.3.3
 * @date Create at 2020/9/29
 * @since
 */
@Component
public class MyBeanPostProcessor implements BeanPostProcessor {

	@Override
	public Object postProcessBeforeInitialization(@NonNull Object bean, @NonNull String beanName) throws BeansException {
		Console.log("Before: beanName={} => bean=[{}]",beanName, bean);
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(@NonNull Object bean, @NonNull String beanName) throws BeansException {
		Console.log("After: beanName={} => bean=[{}]",beanName, bean);
		Console.log("{} classLoader {}",beanName,bean.getClass().getClassLoader().getClass());
		Console.log("**********************{}****************************",beanName);
		return bean;
	}
}
