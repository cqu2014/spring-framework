package summer.nj.config;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import summer.nj.dto.Animal;
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
public class SummerConfig {

	@Bean("animal")
	public AnimalFactoryBean animalFactoryBean(){
		return new AnimalFactoryBean("Tiger");
	}
}
