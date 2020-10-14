package summer.nj.extend;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * @author Oliver Wang
 * @description Spring 提供 InitializingBean和DisposableBean接口扩展
 * @created by IntelliJ IDEA 2020.02
 * @date Create at 2020/10/12
 * @since
 */
@Component
public class LifecycleBean implements InitializingBean, DisposableBean {

	private String beanName;

	public void setBeanName(String beanName) {
		System.out.println("start set beanName:"+beanName);
		this.beanName = beanName;
	}

	public String getBeanName(){
		return beanName;
	}

	@Override
	public void destroy() throws Exception {
		this.beanName = null;
		System.out.println("destroy is invoking");
	}

	/**
	 * 对象属性设置完成被触发
	 *
	 * @throws Exception
	 */
	@Override
	public void afterPropertiesSet() throws Exception {
		if (StringUtils.isEmpty(beanName)){
			setBeanName("afterPropertiesSet set beanName");
		}
		System.out.println("afterPropertiesSet is called,beanName: " + this.getClass().getSimpleName());
	}
}
