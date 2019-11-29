package ab.tjl.tc.dubbo.api.graphql;

import ab.tjl.tc.dubbo.api.service.AdService;
import ab.tjl.tc.dubbo.api.vo.ad.index.IndexAdResult;
import ab.tjl.tc.dubbo.api.vo.ad.index.IndexAdResultData;
import ab.tjl.tc.dubbo.server.pojo.Ad;
import ab.tjl.tc.dubbo.server.vo.PageInfo;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author:TangJiLin
 * @Description:广告graphql
 * @Date: Created in 2019/11/28 19:26
 * @Modified By:
 */
@Component
public class AdDataFetcher implements MyDataFetcher{
    @Autowired
    private AdService adService;

    @Override
    public String fieldName() {
        return "IndexAdList";
    }

    @Override
    public Object dataFetcher(DataFetchingEnvironment environment) {
        PageInfo<Ad> adPageInfo = this.adService.queryAdList(1, 1, 3);
        List<Ad> ads = adPageInfo.getRecords();

        List<IndexAdResultData> list = new ArrayList<>();
        for (Ad ad : ads) {
            list.add(new IndexAdResultData(ad.getUrl()));
        }
        return new IndexAdResult(list);
    }
}
