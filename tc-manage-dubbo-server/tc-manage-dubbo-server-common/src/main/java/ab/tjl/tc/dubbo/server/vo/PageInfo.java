package ab.tjl.tc.dubbo.server.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Collections;
import java.util.List;

/**
 * @Author:TangJiLin
 * @Description:
 * @Date: Created in 2019/11/28 17:10
 * @Modified By:
 */
@Data
@AllArgsConstructor
public class PageInfo<T> implements java.io.Serializable{
    private static final long serialVersionUID = -1658351450858106127L;
    /**
     * 总条数
     */
    private Integer total;
    /**
     * 当前页
     */
    private Integer pageNum;
    /**
     * 一页显示的大小
     */
    private Integer pageSize;
    /**
     * 数据列表
     */
    private List<T> records = Collections.emptyList();
}
