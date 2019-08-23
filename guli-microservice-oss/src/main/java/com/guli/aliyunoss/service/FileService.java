package com.guli.aliyunoss.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


public interface FileService {

    /**
     * 文件上传至阿里云
     * @param file
     * @return
     */
    String upload(MultipartFile file);

}
