package ab.tjl.tc.dubbo.api.service;

import ab.tjl.tc.dubbo.api.vo.Pagination;
import ab.tjl.tc.dubbo.api.vo.TableResult;
import ab.tjl.tc.dubbo.server.api.ApiHouseResourcesService;
import ab.tjl.tc.dubbo.server.pojo.HouseResources;
import ab.tjl.tc.dubbo.server.vo.PageInfo;
import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Service;

/**
 * @Author:TangJiLin
 * @Description:api房源业务
 * @Date: Created in 2019/11/24 14:50
 * @Modified By:
 */
@Service
public class HouseResourcesService {
    @Reference(version = "1.0.0")
    private ApiHouseResourcesService apiHouseResourcesService;

    public boolean save(HouseResources houseResources){
        int result = this.apiHouseResourcesService.saveHouseResources(houseResources);
        return result == 1;
    }

    public TableResult<HouseResources> queryList(HouseResources houseResources, Integer currentPage, Integer pageSize) {
        PageInfo<HouseResources> pageInfo = this.apiHouseResourcesService.
                queryHouseResourcesList(currentPage, pageSize, houseResources);
        return new TableResult<>(pageInfo.getRecords(), new Pagination(currentPage, pageSize, pageInfo.getTotal()));
    }

    /**
     * 根据房源id查询房源数据
     * @param id
     * @return
     */
    public HouseResources queryHouseResourceById(Long id){
        //调用dubbo中的服务进行查询数据
        return this.apiHouseResourcesService.queryHouseResourcesById(id);
    }

    public boolean update(HouseResources houseResources) {
        return this.apiHouseResourcesService.updateHouseResources(houseResources);
    }
}
