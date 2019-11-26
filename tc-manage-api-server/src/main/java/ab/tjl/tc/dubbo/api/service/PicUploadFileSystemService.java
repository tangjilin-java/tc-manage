package ab.tjl.tc.dubbo.api.service;

import ab.tjl.tc.dubbo.api.vo.PicUploadResult;
import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Date;

/**
 * @Author:TangJiLin
 * @Description:图片存储到本地磁盘
 * @Date: Created in 2019/11/25 19:41
 * @Modified By:
 */
@Service
public class PicUploadFileSystemService {
    // 允许上传的格式
    private static final String[] IMAGE_TYPE = new String[]{".bmp", ".jpg",
            ".jpeg", ".gif", ".png"};
    public PicUploadResult upload(MultipartFile uploadFile) {
        // 校验图片格式
        boolean isLegal = false;
        for (String type : IMAGE_TYPE) {
            if (StringUtils.endsWithIgnoreCase(uploadFile.getOriginalFilename(),
                    type)) {
                isLegal = true;
                break;
            }
        }
        // 封装Result对象，并且将文件的byte数组放置到result对象中
        PicUploadResult fileUploadResult = new PicUploadResult();
        if (!isLegal) {
            fileUploadResult.setStatus("error");
            return fileUploadResult;
        }
        // 文件新路径
        String fileName = uploadFile.getOriginalFilename();
        String filePath = getFilePath(fileName);
        // 生成图片的绝对引用地址
        String picUrl = StringUtils.replace(StringUtils.substringAfter(filePath,
                "D:\\IDEA\\TC-House\\images"),
                "\\", "/");
        fileUploadResult.setName("http://image.tc.com" + picUrl);
        File newFile = new File(filePath);
        // 写文件到磁盘
        try {
            uploadFile.transferTo(newFile);
        } catch (IOException e) {
            e.printStackTrace();
        //上传失败
            fileUploadResult.setStatus("error");
            return fileUploadResult;
        }
        fileUploadResult.setStatus("done");
        fileUploadResult.setUid(String.valueOf(System.currentTimeMillis()));
        return fileUploadResult;
    }
    private String getFilePath(String sourceFileName) {
        String baseFolder = "D:\\IDEA\\TC-House\\images" + File.separator
                + "images";
        Date nowDate = new Date();
        // yyyy/MM/dd
        String fileFolder = baseFolder + File.separator + new
                DateTime(nowDate).toString("yyyy")
                + File.separator + new DateTime(nowDate).toString("MM") +
                File.separator
                + new DateTime(nowDate).toString("dd");
        File file = new File(fileFolder);
        if (!file.isDirectory()) {
        // 如果目录不存在，则创建目录
            file.mkdirs();
        }
        // 生成新的文件名
        String fileName = new DateTime(nowDate).toString("yyyyMMddhhmmssSSSS")
                + RandomUtils.nextInt(100, 9999) + "." +
                StringUtils.substringAfterLast(sourceFileName, ".");
        return fileFolder + File.separator + fileName;
    }

}
