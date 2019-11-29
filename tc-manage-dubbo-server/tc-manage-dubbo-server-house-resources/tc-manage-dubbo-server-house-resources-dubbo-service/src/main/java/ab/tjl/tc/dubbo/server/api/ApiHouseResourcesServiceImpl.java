package ab.tjl.tc.dubbo.server.api;

import ab.tjl.tc.dubbo.server.pojo.HouseResources;
import ab.tjl.tc.dubbo.server.service.HouseResourcesService;
import ab.tjl.tc.dubbo.server.vo.PageInfo;
import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author:TangJiLin
 * @Description:房源dubbo服务
 * @Date: Created in 2019/11/24 14:13
 * @Modified By:
 */
@Service(version = "1.0.0") // 这是dubbo服务，对外进行暴露
public class ApiHouseResourcesServiceImpl implements ApiHouseResourcesService {
    @Autowired
    private HouseResourcesService houseResourcesService;

    @Override
    public int saveHouseResources(HouseResources houseResources) {
        return this.houseResourcesService.saveHouseResources(houseResources);
    }

    @Override
    public PageInfo<HouseResources> queryHouseResourcesList(int page, int pageSize,HouseResources queryCondition) {
        return this.houseResourcesService.queryHouseResourcesList(page, pageSize, queryCondition);
    }


    @Override
    public HouseResources queryHouseResourcesById(Long id) {
        return this.houseResourcesService.queryHouseResourcesById(id);
    }

    @Override
    public boolean updateHouseResources(HouseResources houseResources) {
        return this.houseResourcesService.updateHouseResources(houseResources);
    }

}
