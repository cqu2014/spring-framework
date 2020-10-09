package summer.nj.service.impl;

import cn.hutool.core.lang.Console;
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
		Console.log("Hello Spring,I miss you so much");
	}

	@Override
	public void hello(String prefix) {
		Console.log("Hello {},I miss you so much",prefix);
	}

	@Override
	public void destroy() {
		Console.log("PrintServiceImpl destroy");
	}
}
