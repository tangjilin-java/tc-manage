package ab.tjl.tc.dubbo.api.controller;

import ab.tjl.tc.dubbo.api.service.PicUploadFileSystemService;
import ab.tjl.tc.dubbo.api.service.PicUploadService;
import ab.tjl.tc.dubbo.api.vo.PicUploadResult;
import ab.tjl.tc.dubbo.api.vo.PicUploadVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author:TangJiLin
 * @Description:图片上传
 * @Date: Created in 2019/11/25 18:53
 * @Modified By:
 */
@RequestMapping("pic/upload")
@Controller
public class PicUploadController {
   /*
    @Autowired
    private PicUploadService picUploadService;

   //@RequestMapping("/file/upload")
    @PostMapping
    @ResponseBody
    public PicUploadVO upload(@RequestParam("file") MultipartFile uploadFile) {
       *//* MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        MultipartFile file = multipartRequest.getFile("file");

        *//*
        try {
            String fileName = picUploadService.upload(uploadFile.getInputStream(), uploadFile.getContentType(), uploadFile.getOriginalFilename());
            PicUploadVO picUploadVO = new PicUploadVO();
            picUploadVO.setSuccess(1);
            picUploadVO.setName(fileName);
            return picUploadVO;
        } catch (Exception e) {
            PicUploadVO fileDTO = new PicUploadVO();
            fileDTO.setSuccess(0);
            fileDTO.setMessage("上传失败");
            return fileDTO;
        }
    }*/

    @Autowired
    private PicUploadFileSystemService picUploadService;

    @PostMapping
    @ResponseBody
    public PicUploadResult upload(@RequestParam("file") MultipartFile uploadFile) throws Exception {
        return this.picUploadService.upload(uploadFile);
    }

}
