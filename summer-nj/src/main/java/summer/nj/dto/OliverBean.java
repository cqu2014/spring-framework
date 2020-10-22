package summer.nj.dto;

import summer.nj.annotation.Oliver;

import javax.annotation.PostConstruct;

/**
 * @author Oliver Wang
 * @description
 * @created by IntelliJ IDEA 2020.02
 * @date Create at 2020/10/21
 * @since
 */
@Oliver
public class OliverBean {
	private String name;

	@PostConstruct
   	private void init(){
		name = "OliverWang";
		System.out.println(name);
	}
}
