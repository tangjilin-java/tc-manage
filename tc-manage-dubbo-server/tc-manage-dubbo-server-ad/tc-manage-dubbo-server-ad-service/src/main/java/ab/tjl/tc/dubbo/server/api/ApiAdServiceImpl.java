package ab.tjl.tc.dubbo.server.api;

import ab.tjl.tc.dubbo.server.pojo.Ad;
import ab.tjl.tc.dubbo.server.service.AdService;
import ab.tjl.tc.dubbo.server.vo.PageInfo;
import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author:TangJiLin
 * @Description:广告接口实现类
 * @Date: Created in 2019/11/28 17:13
 * @Modified By:
 */
@Service(version = "1.0.0")
public class ApiAdServiceImpl implements ApiAdService {
    @Autowired
    private AdService adService;
    @Override
    public PageInfo<Ad> queryAdList(Integer type, Integer page, Integer pageSize) {
        Ad ad = new Ad();
        ad.setType(type);
        return this.adService.queryAdList(ad, page, pageSize);
    }
}

