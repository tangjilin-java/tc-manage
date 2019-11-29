package ab.tjl.tc.dubbo.server.api;

import ab.tjl.tc.dubbo.server.pojo.Ad;
import ab.tjl.tc.dubbo.server.vo.PageInfo;

/**
 * @Author:TangJiLin
 * @Description:广告接口
 * @Date: Created in 2019/11/28 17:09
 * @Modified By:
 */
public interface ApiAdService {
    /**
     * 分页查询广告数据
     *
     * @param type 广告类型
     * @param page 页数
     * @param pageSize 每页显示的数据条数
     * @return
     */
    PageInfo<Ad> queryAdList(Integer type, Integer page, Integer pageSize);
}

