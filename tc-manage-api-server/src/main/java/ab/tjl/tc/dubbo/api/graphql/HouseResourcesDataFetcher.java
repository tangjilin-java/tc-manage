package ab.tjl.tc.dubbo.api.graphql;

import ab.tjl.tc.dubbo.api.service.HouseResourcesService;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author:TangJiLin
 * @Description:实现类
 * @Date: Created in 2019/11/27 14:02
 * @Modified By:
 */
@Component //加入到Spring容器
public class HouseResourcesDataFetcher implements MyDataFetcher {
    @Autowired
    private HouseResourcesService houseResourcesService;
    @Override
    public String fieldName() {
        return "HouseResources";
    }
    @Override
    public Object dataFetcher(DataFetchingEnvironment environment) {
        Long id = environment.getArgument("id");
        return this.houseResourcesService.queryHouseResourceById(id);
    }
}
