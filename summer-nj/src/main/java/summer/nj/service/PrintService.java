package summer.nj.service;

/**
 * @Author Oliver Wang
 * @Description
 * @Created by IntelliJ IDEA 2018.3.3
 * @Date Create at 2020/9/21
 * @Since
 */

public interface PrintService {
	/**
	 * Hello spring
	 */
	void hello();

	/**
	 * Hello spring
	 *
	 * @param prefix
	 */
	void hello(String prefix);

	/**
	 * 自定义收尾函数
	 */
	void destroy();
}
