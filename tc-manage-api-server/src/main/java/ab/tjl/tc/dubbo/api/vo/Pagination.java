package ab.tjl.tc.dubbo.api.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @Author:TangJiLin
 * @Description:分页
 * @Date: Created in 2019/11/26 14:09
 * @Modified By:
 */
@Data
@AllArgsConstructor
public class Pagination {
    private Integer current;
    private Integer pageSize;
    private Integer total;
}
