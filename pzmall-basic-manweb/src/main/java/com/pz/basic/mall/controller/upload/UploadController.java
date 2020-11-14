package com.pz.basic.mall.controller.upload;

import com.pz.basic.mall.domain.base.Result;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

/**
 * @author percy
 * @date 2020/8/24 14:48
 */

@RestController
@RequestMapping("/upload")
public class UploadController {

    @Value("${FILE_UPLOAD_PATH}")
    private String file_upload_path;//上传文件存储路径
    @Value("${IMG_SERVER_URL}")
    private String img_server_url;//图片服务器域名

    private static String CONTENT_FLODER="/content/";

    @RequestMapping("/uploadFile")
    public Result uploadFile(MultipartFile file, String moudle){
        Result result = new Result();
        try {
            if(!file.isEmpty()){
                //获取文件名称
                String filename = file.getOriginalFilename();
                //限制文件上传的类型
                if ("image/png".equals(file.getContentType())||"image/jpeg".equals(file.getContentType())||"image/jpg".equals(file.getContentType())) {
                    //不同的moudle对应不同的目录
                    String dirPath = file_upload_path + "/" + moudle + "/";
                    File folder = new File(dirPath);
                    //如果保存文件的地址不存在，就先创建目录
                    if (!folder.exists()){
                        folder.mkdirs();
                    }
                    File newFile = new File(dirPath, filename);
                    //完成文件上传
                    file.transferTo(newFile);
                    String url = img_server_url + CONTENT_FLODER + moudle + "/" + filename;
                    result.addDefaultModel(url);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            result.setSuccess(false);
            return result;
        }
        return result;
    }

}
