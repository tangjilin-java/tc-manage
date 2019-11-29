package ab.tjl.tc.dubbo.server.service;

import ab.tjl.tc.dubbo.server.pojo.Ad;
import ab.tjl.tc.dubbo.server.vo.PageInfo;

/**
 * @Author:TangJiLin
 * @Description:广告接口
 * @Date: Created in 2019/11/28 17:15
 * @Modified By:
 */
public interface AdService {
    PageInfo<Ad> queryAdList(Ad ad, Integer page, Integer pageSize);
}
