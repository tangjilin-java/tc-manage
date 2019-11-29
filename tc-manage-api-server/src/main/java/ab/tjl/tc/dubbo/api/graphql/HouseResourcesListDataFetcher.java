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
public class HouseResourcesListDataFetcher implements MyDataFetcher {
    @Autowired
    private HouseResourcesService houseResourcesService;
    @Override
    public String fieldName() {
        return "HouseResourcesList";
    }
    @Override
    public Object dataFetcher(DataFetchingEnvironment environment) {
        Integer page = environment.getArgument("page");
        if (null == page){
            page = 1;
        }
        Integer pageSize = environment.getArgument("pageSize");
        if (null == pageSize){
            pageSize = 1;
        }
        return this.houseResourcesService.queryList(null,page,pageSize);
    }
}
