package ab.tjl.tc.dubbo.server.pojo;

import lombok.Data;

import java.util.Date;

/**
 * @Author:TangJiLin
 * @Description:实体父类
 * @Date: Created in 2019/11/24 13:29
 * @Modified By:
 */
@Data
public abstract class BasePojo implements java.io.Serializable{
    private Date created;
    private Date updated;
}
