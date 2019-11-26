package ab.tjl.tc.dubbo.server.service;

import ab.tjl.tc.dubbo.server.pojo.HouseResources;
import ab.tjl.tc.dubbo.server.vo.PageInfo;

/**
 * @Author:TangJiLin
 * @Description:房源业务层接口
 * @Date: Created in 2019/11/24 14:03
 * @Modified By:
 */
public interface HouseResourcesService {
    /**
     *
     * @param houseResources
     *
     * @return -1:输入的参数不符合要求，0：数据插入数据库失败，1：成功
     */
    int saveHouseResources(HouseResources houseResources);

    PageInfo<HouseResources> queryHouseResourcesList(int page, int pageSize, HouseResources queryCondition);
}

