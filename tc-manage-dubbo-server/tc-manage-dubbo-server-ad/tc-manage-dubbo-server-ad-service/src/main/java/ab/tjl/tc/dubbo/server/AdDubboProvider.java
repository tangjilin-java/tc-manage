package ab.tjl.tc.dubbo.server;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * @Author:TangJiLin
 * @Description:Ad启动类
 * @Date: Created in 2019/11/28 17:37
 * @Modified By:
 */
@SpringBootApplication
public class AdDubboProvider {
    public static void main(String[] args) {
        new SpringApplicationBuilder(AdDubboProvider.class)
                .web(WebApplicationType.NONE) // 非 Web 应用
                .run(args);
    }
}
