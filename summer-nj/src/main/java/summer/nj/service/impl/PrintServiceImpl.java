package summer.nj.service.impl;

import org.springframework.stereotype.Component;
import summer.nj.service.PrintService;

/**
 * @author Oliver Wang
 * @description
 * @created by IntelliJ IDEA 2018.3.3
 * @date Create at 2020/9/21
 * @since
 */
@Component
public class PrintServiceImpl implements PrintService {
	@Override
	public void hello() {
		System.out.println("Hello Spring,I miss you so much");
	}
}
