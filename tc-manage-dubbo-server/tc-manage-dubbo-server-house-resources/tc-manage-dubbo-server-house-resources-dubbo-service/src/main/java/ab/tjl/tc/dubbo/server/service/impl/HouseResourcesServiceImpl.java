package ab.tjl.tc.dubbo.server.service.impl;

import ab.tjl.tc.dubbo.server.pojo.HouseResources;
import ab.tjl.tc.dubbo.server.service.HouseResourcesService;
import ab.tjl.tc.dubbo.server.vo.PageInfo;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author:TangJiLin
 * @Description:
 * @Date: Created in 2019/11/24 14:05
 * @Modified By:
 */
@Service //这是一个Spring的服务
@Transactional //开启事务
public class HouseResourcesServiceImpl extends BaseServiceImpl<HouseResources> implements HouseResourcesService {
    @Override
    public int saveHouseResources(HouseResources houseResources) {
        // 编写校验逻辑，如果教研不通过，返回-1
        if (StringUtils.isBlank(houseResources.getTitle())) {
            //不符合要求
            return -1;
        }
        return super.save(houseResources);
    }


    @Override
    public PageInfo<HouseResources> queryHouseResourcesList(int page, int pageSize, HouseResources queryCondition) {
        QueryWrapper queryWrapper = new QueryWrapper();

        queryWrapper.orderByDesc("updated");
        IPage iPage = super.queryPageList(queryWrapper, page, pageSize);

        return new PageInfo<HouseResources>(Long.valueOf(iPage.getTotal()).intValue(),page,pageSize,iPage.getRecords());
    }
}

