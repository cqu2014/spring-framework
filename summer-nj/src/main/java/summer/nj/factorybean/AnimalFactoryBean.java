package summer.nj.factorybean;

import org.springframework.beans.factory.FactoryBean;
import summer.nj.dto.Animal;
import summer.nj.dto.Monkey;
import summer.nj.dto.Tiger;

/**
 * @author Oliver Wang
 * @description
 * @created by IntelliJ IDEA 2020.02
 * @date Create at 2020/10/12
 * @since
 */
public class AnimalFactoryBean implements FactoryBean<Animal> {
	private String animal;

	public AnimalFactoryBean(String animal){
		this.animal = animal;
	}

	@Override
	public Animal getObject() throws Exception {
		if ("Monkey".equals(animal)) {
			return new Monkey();
		} else if ("Tiger".equals(animal)) {
			return new Tiger();
		} else {
			return null;
		}
	}

	@Override
	public Class<?> getObjectType() {
		return Animal.class;
	}
}
