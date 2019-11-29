package com.lxl.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/file/")
@CrossOrigin
public class UploadController {
    @Value("${file.path}")
    private String filePath;
    @Value("${file.domain}")
    private String fileDomain;

    @RequestMapping("upload")
    public Object upload(@RequestParam("file") MultipartFile file) throws IOException {

        /** 文件名 **/
        String originaFileName = file.getOriginalFilename();
        String fileName =  UUID.randomUUID()+ originaFileName.substring(originaFileName.lastIndexOf("."));
        String absFileName = filePath+fileName;
        /** 保存文件　**/
        File saveFile = new File(absFileName);
        file.transferTo(saveFile);
        /** 封装返回结果　**/
        Map<String,Object> resultMap = new HashMap<>();
        resultMap.put("result",true);
        resultMap.put("fileName",fileName);
        resultMap.put("fileUrl",fileDomain+fileName);
        return resultMap;
    }

    @RequestMapping("delByFileName")
    public Object delByFileName(@RequestParam("fileName") String fileName) throws IOException {
        /** 保存文件　**/
        File file = new File(filePath+fileName);
        file.delete();
        /** 封装返回结果　**/
        Map<String,Object> resultMap = new HashMap<>();
        resultMap.put("result",true);
        return resultMap;
    }
}
