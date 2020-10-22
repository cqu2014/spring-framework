package summer.nj.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import summer.nj.extend.register.OliverAutoConfigureMyRegistrar;

/**
 * @author Oliver Wang
 * @description
 * @created by IntelliJ IDEA 2020.02
 * @date Create at 2020/10/21
 * @since
 */
@Configuration
@ComponentScan("summer.nj.dto")
@Import(OliverAutoConfigureMyRegistrar.class)
public class OliverConfig {
}
