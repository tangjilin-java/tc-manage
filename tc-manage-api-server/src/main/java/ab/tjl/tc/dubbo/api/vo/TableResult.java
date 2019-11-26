package ab.tjl.tc.dubbo.api.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

/**
 * @Author:TangJiLin
 * @Description:房源响应结果
 * @Date: Created in 2019/11/26 14:07
 * @Modified By:
 */
@Data
@AllArgsConstructor
public class TableResult<T> {
    private List<T> list;
    private Pagination pagination;
}

