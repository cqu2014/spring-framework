package summer.nj.service.impl;

import cn.hutool.core.lang.Console;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @author Oliver Wang
 * @description BeanFactoryPostProcessor是spring提供的另外一个钩子函数
 * 	在所有bean definition均加载完毕但是尚未初始化时调用，允许用户任意修改所有bean的属性
 * @created IDEAJ 2020.02
 * @date Create at 2020/9/29
 * @since
 */
@Component
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
	@Override
	public void postProcessBeanFactory(@NonNull ConfigurableListableBeanFactory beanFactory) throws BeansException {
		Console.log("MyBeanFactoryPostProcessor...postProcessBeanFactory...");
		int count = beanFactory.getBeanDefinitionCount();
		String[] names = beanFactory.getBeanDefinitionNames();
		Console.log("当前BeanFactory中有 {} 个Bean",count);
		Console.log(Arrays.asList(names));

		DefaultListableBeanFactory factory = (DefaultListableBeanFactory) beanFactory;
		BeanDefinition beanDefinition = factory.getBeanDefinition("printServiceImpl");
		beanDefinition.setDescription("Oliver change it before initial");
	}
}
