package summer.nj.extend.postprocessor;

import cn.hutool.core.lang.Console;
import cn.hutool.json.JSONUtil;
import org.springframework.beans.BeansException;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @author Oliver Wang
 * @description BeanFactoryPostProcessor是spring提供的另外一个钩子函数
 * 	在所有bean definition均加载完毕但是尚未实例化时调用，允许用户操作BeanFactory并任意修改所有bean的属性
 * 	spring 初始化容器只执行一次
 * @created IDEAJ 2020.02
 * @date Create at 2020/9/29
 * @since
 */
@Component
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
	/**
	 *	ConfigurableListableBeanFactory功能非常丰富，最基本的，它携带了每个Bean的基本信息
	 *
	 * @param beanFactory the bean factory used by the application context
	 * @throws BeansException
	 */
	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		Console.log("BeanFactoryPostProcessor...postProcessBeanFactory...");
		int count = beanFactory.getBeanDefinitionCount();
		String[] names = beanFactory.getBeanDefinitionNames();
		Console.log("当前BeanFactory中有 {} 个bean definition",count);
		Console.log(Arrays.asList(names));

		BeanDefinition beanDefinition = beanFactory.getBeanDefinition("printServiceImpl");
		beanDefinition.setDescription("Oliver change it before initial");
		beanDefinition.setDestroyMethodName("destroy");

		Console.log("********BeanFactoryPostProcessor修改jumpMonkey的Scope*****************");
		BeanDefinition jumpMonkeyDefinition = beanFactory.getBeanDefinition("jumpMonkey");
		MutablePropertyValues jumpMonkeyDefinitionPropertyValues = jumpMonkeyDefinition.getPropertyValues();
		Console.log("jumpMonkeyDefinitionPropertyValues:{}", JSONUtil.toJsonStr(jumpMonkeyDefinitionPropertyValues));
		Console.log("jumpMonkeyDefinition's scope:{}",jumpMonkeyDefinition.getScope());
		jumpMonkeyDefinition.setScope("prototype");
		Console.log("jumpMonkeyDefinition's scope:{}",jumpMonkeyDefinition.getScope());
		Console.log("jumpMonkeyDefinitionPropertyValues:{}", JSONUtil.toJsonStr(jumpMonkeyDefinitionPropertyValues));
	}
}
