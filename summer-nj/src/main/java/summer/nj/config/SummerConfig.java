package summer.nj.config;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import summer.nj.extend.MyImportBeanDefinitionRegistrar;
import summer.nj.factorybean.AnimalFactoryBean;

/**
 * @author Oliver Wang
 * @description 配置信息
 * @created by IntelliJ IDEA 2018.3.3
 * @date Create at 2020/9/21
 * @since
 */
@Configurable
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
