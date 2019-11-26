package ab.tjl.tc.dubbo.server.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @Author:TangJiLin
 * @Description:Mybatis配置类
 * @Date: Created in 2019/11/24 14:02
 * @Modified By:
 */
@MapperScan("ab.tjl.tc.dubbo.server.mapper")
@Configuration
public class MybatisConfig {

}

