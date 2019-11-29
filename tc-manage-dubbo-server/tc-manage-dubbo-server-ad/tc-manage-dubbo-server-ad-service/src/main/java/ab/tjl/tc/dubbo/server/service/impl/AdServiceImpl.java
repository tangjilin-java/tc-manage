package ab.tjl.tc.dubbo.server.service.impl;

import ab.tjl.tc.dubbo.server.pojo.Ad;
import ab.tjl.tc.dubbo.server.service.AdService;
import ab.tjl.tc.dubbo.server.service.BaseServiceImpl;
import ab.tjl.tc.dubbo.server.vo.PageInfo;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.stereotype.Service;

/**
 * @Author:TangJiLin
 * @Description:广告接口实现类
 * @Date: Created in 2019/11/28 17:16
 * @Modified By:
 */
@Service
public class AdServiceImpl extends BaseServiceImpl implements AdService {
    @Override
    public PageInfo<Ad> queryAdList(Ad ad, Integer page, Integer pageSize) {
        QueryWrapper queryWrapper = new QueryWrapper();
        //排序
        queryWrapper.orderByDesc("updated");

        //查询的条件
        queryWrapper.eq("type",ad.getType());

        IPage iPage = super.queryPageList(queryWrapper,page,pageSize);

        return new PageInfo<>(Long.valueOf(iPage.getTotal()).intValue(),page,pageSize,iPage.getRecords());

    }
}

