package ab.tjl.tc.dubbo.api.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author:TangJiLin
 * @Description:redis基本配置
 * @Date: Created in 2019/11/29 17:56
 * @Modified By:
 */
@Component
@ConfigurationProperties(prefix = "spring.redis.cluster")
@Data
public class ClusterConfigurationProperties {

    private List<String> nodes;
    private Integer maxRedirects;//最大重定向次数

}
