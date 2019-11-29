package ab.tjl.tc.dubbo.server.service;

import ab.tjl.tc.dubbo.server.pojo.BasePojo;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

/**
 * @Author:TangJiLin
 * @Description:业务层实现父类
 * @Date: Created in 2019/11/24 14:05
 * @Modified By:
 */
public abstract class BaseServiceImpl<T extends BasePojo> {
    @Autowired
    private BaseMapper<T> mapper;

    /**
     * 根据id查询数据
     *
     * @param id
     * @return
     */
    public T queryById(Long id) {
        return this.mapper.selectById(id);
    }
    /**
     * 查询所有数据
     *
     * @return
     */
    public List<T> queryAll() {
        return this.mapper.selectList(null);
    }
    /**
     * 根据条件查询一条数据
     *
     * @param record
     * @return
     */
    public T queryOne(T record) {
        return this.mapper.selectOne(new QueryWrapper<>(record));
    }
    /**
     * 根据条件查询数据列表
     *
     * @param record
     * @return
     */
    public List<T> queryListByWhere(T record) {
        return this.mapper.selectList(new QueryWrapper<>(record));
    }
    /**
     * 根据条件分页查询数据列表
     *
     * @param record
     * @param page
     * @param rows
     * @return
     */
    public IPage<T> queryPageListByWhere(T record, Integer page, Integer rows) {
    // 获取分页数据
        return this.mapper.selectPage(new Page<T>(page, rows), new QueryWrapper<>
                (record));
    }
    /**
     * 根据条件分页查询数据列表
     *
     * @param queryWrapper
     * @param page
     * @param pageSize
     * @return
     */
    public IPage<T> queryPageList(QueryWrapper<T> queryWrapper, Integer page,Integer pageSize) {
        // 获取分页数据
        return this.mapper.selectPage(new Page<T>(page, pageSize), queryWrapper);
    }
    /**
     * 保存数据
     *
     * @param record
     * @return
     */
    public Integer save(T record) {
        record.setCreated(new Date());
        record.setUpdated(record.getCreated());
        return this.mapper.insert(record);
    }
    /**
     * 更新数据
     *
     * @param record
     * @return
     */
    public Integer update(T record) {
        record.setUpdated(new Date());
        return this.mapper.updateById(record);
    }
    /**
     * 根据id删除数据
     *
     * @param id
     * @return
     */
    public Integer deleteById(Long id) {
        return this.mapper.deleteById(id);
    }
    /**
     * 根据ids批量删除数据
     *
     * @param ids
     * @return
     */
    public Integer deleteByIds(List<Long> ids) {
        return this.mapper.deleteBatchIds(ids);
    }
    /**
     * 根据条件删除数据
     *
     * @param record
     * @return
     */
    public Integer deleteByWhere(T record){
        return this.mapper.delete(new QueryWrapper<>(record));
    }
}
