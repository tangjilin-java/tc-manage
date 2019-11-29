package ab.tjl.tc.dubbo.api.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author:TangJiLin
 * @Description:前端数据封装类
 * @Date: Created in 2019/11/28 18:44
 * @Modified By:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class WebResult {

    @JsonIgnore
    private Integer status;
    @JsonIgnore
    private String msg;
    @JsonIgnore
    private List<?> list;

    public static WebResult ok(List<?> list){
        return new WebResult(200,"成功",list);
    }

    public static WebResult ok(List<?> list,String msg){
        return new WebResult(200,msg,list);
    }

    public Map<String ,Object> getData(){
        Map<String,Object> map = new HashMap<>();
        map.put("list",this.list);
        return map;
    }

    public Map<String ,Object> getMeta(){
        Map<String,Object> map = new HashMap<>();
        map.put("status",status);
        map.put("msg",msg);
        return map;
    }
}
