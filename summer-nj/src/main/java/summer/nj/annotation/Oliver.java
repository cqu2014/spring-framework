package summer.nj.annotation;

import java.lang.annotation.*;

/**
 * 借助ImportBeanDefinitionRegistrar 编写注解实现@Component功能
 */
@Documented
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE,ElementType.FIELD,ElementType.METHOD})
public @interface Oliver {
}
