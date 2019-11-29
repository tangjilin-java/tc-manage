package ab.tjl.tc.dubbo.api.service;

import ab.tjl.tc.dubbo.server.api.ApiAdService;
import ab.tjl.tc.dubbo.server.pojo.Ad;
import ab.tjl.tc.dubbo.server.vo.PageInfo;
import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Service;

/**
 * @Author:TangJiLin
 * @Description:广告接口
 * @Date: Created in 2019/11/28 18:36
 * @Modified By:
 */
@Service
public class AdService {

    @Reference(version = "1.0.0")
    private ApiAdService apiAdService;

    public PageInfo<Ad> queryAdList(Integer type,Integer page,Integer pageSize){
        return this.apiAdService.queryAdList(type,page,pageSize);
    }
}
