package ab.tjl.tc.dubbo.api.graphql;

import graphql.schema.DataFetchingEnvironment;

/**
 * @Author:TangJiLin
 * @Description:查询方法定义接口
 * @Date: Created in 2019/11/27 13:54
 * @Modified By:
 */
public interface MyDataFetcher {
    /**
     * 查询名称
     *
     * @return
     */
    String fieldName();
    /**
     * 具体实现数据查询的逻辑
     *
     * @param environment
     * @return
     */
    Object dataFetcher(DataFetchingEnvironment environment);
}
