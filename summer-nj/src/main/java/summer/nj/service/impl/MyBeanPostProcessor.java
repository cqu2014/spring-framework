package summer.nj.service.impl;

import cn.hutool.core.lang.Console;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

/**
 * @author Oliver Wang
 * @description BeanPostProcessor是Bean factory提供的hook函数，允许用户在bean初始化前和初始化后做个性化处理
 * 				该扩展本身也是spring的bean，但是其初始化要早于普通的bean，在其中注入普通bean会出现问题
 * @created by wang 2018.3.3
 * @date Create at 2020/9/29
 * @since
 */
@Component
public class MyBeanPostProcessor implements BeanPostProcessor {

	@Override
	public Object postProcessBeforeInitialization(@NonNull Object bean, @NonNull String beanName) throws BeansException {
		Console.log("Before: beanName={} => bean=[{}]",beanName, bean);
		if (bean instanceof PrintServiceImpl){
			PrintServiceImpl newBean = (PrintServiceImpl) bean;
			newBean.hello("MyBeanPostProcessor ");
		}
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
