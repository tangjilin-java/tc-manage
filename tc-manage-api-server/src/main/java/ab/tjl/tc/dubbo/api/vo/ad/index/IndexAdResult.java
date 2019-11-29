package ab.tjl.tc.dubbo.api.vo.ad.index;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Author:TangJiLin
 * @Description:广告实体优化
 * @Date: Created in 2019/11/28 19:28
 * @Modified By:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class IndexAdResult {
    private List<IndexAdResultData> list;
}

