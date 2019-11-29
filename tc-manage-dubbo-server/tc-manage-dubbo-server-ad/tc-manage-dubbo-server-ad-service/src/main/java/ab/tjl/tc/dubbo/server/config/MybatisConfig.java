package ab.tjl.tc.dubbo.server.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author:TangJiLin
 * @Description:数据配置类
 * @Date: Created in 2019/11/28 17:30
 * @Modified By:
 */
@MapperScan("ab.tjl.tc.dubbo.server.mapper")
@Configuration
public class MybatisConfig {
    /**
     * 分页插件
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }
}

