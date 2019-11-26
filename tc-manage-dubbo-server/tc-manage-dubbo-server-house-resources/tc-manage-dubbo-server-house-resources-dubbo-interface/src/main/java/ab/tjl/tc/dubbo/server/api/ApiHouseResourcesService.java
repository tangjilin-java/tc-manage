package ab.tjl.tc.dubbo.server.api;

import ab.tjl.tc.dubbo.server.pojo.HouseResources;
import ab.tjl.tc.dubbo.server.vo.PageInfo;

/**
 * @Author:TangJiLin
 * @Description:房源api
 * @Date: Created in 2019/11/24 13:54
 * @Modified By:
 */
public interface ApiHouseResourcesService {
    /**
     *新增房源
     * @param houseResources
     *
     * @return -1:输入的参数不符合要求，0：数据插入数据库失败，1：成功
     */
    int saveHouseResources(HouseResources houseResources);

    /**
     * 分页查询房源列表
     * @param page 当前页
     * @param pageSize 页面大小
     * @param queryCondition 查询条件
     * @return
     */
    PageInfo<HouseResources> queryHouseResourcesList(int page, int pageSize, HouseResources queryCondition);
}

