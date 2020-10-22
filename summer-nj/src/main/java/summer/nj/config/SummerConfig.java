package summer.nj.config;

import org.springframework.context.annotation.*;
import summer.nj.extend.postprocessor.MyImportBeanDefinitionRegistrar;
import summer.nj.factorybean.AnimalFactoryBean;

/**
 * @author Oliver Wang
 * @description 配置信息
 * @created by IntelliJ IDEA 2018.3.3
 * @date Create at 2020/9/21
 * @since
 */
@Configuration
@ComponentScan(basePackages = {"summer.nj"})
// @Import(CarConfig.class) // 通过@Import注解引入产生Car实例的配置类
@ImportResource("classpath:beans/commonBean.xml")
@Import(MyImportBeanDefinitionRegistrar.class)
public class SummerConfig {

	@Bean("animal")
	public AnimalFactoryBean animalFactoryBean(){
		return new AnimalFactoryBean("Tiger");
	}
}
