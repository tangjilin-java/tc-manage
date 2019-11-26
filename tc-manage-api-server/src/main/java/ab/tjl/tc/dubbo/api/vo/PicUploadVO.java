package ab.tjl.tc.dubbo.api.vo;

import lombok.Data;

/**
 * @Author:TangJiLin
 * @Description:图片属性封装
 * @Date: Created in 2019/11/25 18:59
 * @Modified By:
 */
@Data
public class PicUploadVO {
    private int success;
    private String message;
   // private String url;
    // 文件唯一标识
    private String uid;
    // 文件名
    private String name;
    // 状态有：uploading done error removed
    private String status;
    // 服务端响应内容，如：'{"status": "success"}'
    private String response;
}
