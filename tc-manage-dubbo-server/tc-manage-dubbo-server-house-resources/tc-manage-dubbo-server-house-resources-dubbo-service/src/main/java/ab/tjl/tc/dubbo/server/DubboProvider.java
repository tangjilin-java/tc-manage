package ab.tjl.tc.dubbo.server;


import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
/**
 * @Author:TangJiLin
 * @Description:启动类
 * @Date: Created in 2019/11/24 14:17
 * @Modified By:
 */
@SpringBootApplication
public class DubboProvider {
    public static void main(String[] args) {
        new SpringApplicationBuilder(DubboProvider.class)
                .web(WebApplicationType.NONE) // 非 Web 应用
                .run(args);
    }
}

