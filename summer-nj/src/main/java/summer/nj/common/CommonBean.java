package summer.nj.common;

/**
 * @author Oliver Wang
 * @description 测试普通bean初始化流程
 * @created by IntelliJ IDEA 2020.02
 * @date Create at 2020/10/14
 * @since
 */
public class CommonBean {
	public String name;

	public CommonBean(){
		System.out.println("CommonBean的无参构造函数被调用");
	}

	public void setName(String name) {
		System.out.println("CommonBean set name = " + name);
		this.name = name;
	}

	public void initMethod()
	{
		System.out.println("Enter CommonBean.initMethod(), name = " + name);
	}

	public void destroyMethod(){
		System.out.println("Enter CommonBean.destroyMethod(), name = " + name);
	}
}
