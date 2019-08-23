package com.guli.aliyunoss.controller;

import com.guli.aliyunoss.service.FileService;
import com.guli.common.vo.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@Api("文件服务")
@RestController
@RequestMapping("admin/oss/file")
public class FileController {

    @Autowired
    private FileService fileService;

    @ApiOperation("上传文件至阿里云OSS")
    @PostMapping("upload")
    public R upload(@RequestParam("file") MultipartFile file) {
        String fileUrl = fileService.upload(file);
        return R.ok().message("上传文件成").data("url", fileUrl);
    }

}
