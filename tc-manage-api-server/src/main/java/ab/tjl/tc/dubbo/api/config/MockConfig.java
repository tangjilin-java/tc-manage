package ab.tjl.tc.dubbo.api.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @Author:TangJiLin
 * @Description:前端数据处理Mock
 * @Date: Created in 2019/11/29 10:12
 * @Modified By:
 */
@Configuration
@PropertySource("classpath:mock-data.properties")
@ConfigurationProperties(prefix = "mock")
@Data
public class MockConfig {

    private String indexMenu;
    private String indexInfo;
    private String indexFaq;
    private String indexHouse;
    private String infosList1;
    private String infosList2;
    private String infosList3;
    private String my;

}
