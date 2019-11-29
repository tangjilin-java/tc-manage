package ab.tjl.tc.dubbo.api.config;

import ab.tjl.tc.dubbo.api.interceptor.RedisCacheInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Author:TangJiLin
 * @Description:注册拦截器redis
 * @Date: Created in 2019/11/29 19:00
 * @Modified By:
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Autowired
    private RedisCacheInterceptor redisCacheInterceptor;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(this.redisCacheInterceptor).addPathPatterns("/**");
    }
}
