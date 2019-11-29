package ab.tjl.tc.dubbo.server.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @Author:TangJiLin
 * @Description:广告实体类
 * @Date: Created in 2019/11/28 17:06
 * @Modified By:
 */
@Data
@Accessors(chain = true)
@TableName("tb_ad")
public class Ad extends BasePojo implements Serializable {

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    //广告类型
    private Integer type;
    //描述
    private String title;
    //'图片URL地址
    private String url;
}

