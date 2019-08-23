package com.guli.aliyunoss.service.impl;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.CannedAccessControlList;
import com.guli.aliyunoss.service.FileService;
import com.guli.aliyunoss.util.ConstantPropertiesUtil;
import com.guli.common.constants.ResultCodeEnum;
import com.guli.common.exception.GuliException;
import lombok.extern.slf4j.Slf4j;
import org.joda.time.DateTime;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.InputStream;
import java.util.UUID;

@Service
@Slf4j
public class FileServiceImpl implements FileService {
    @Override
    public String upload(MultipartFile file) {
        //获取阿里云OSS常量
        String endpoint = ConstantPropertiesUtil.END_POINT;
        String accessKeyId = ConstantPropertiesUtil.ACCESS_KEY_ID;
        String accessKeySecret = ConstantPropertiesUtil.ACCESS_KEY_SCRET;
        String bucketName = ConstantPropertiesUtil.BUCKET_NAME;
        String firstHost = ConstantPropertiesUtil.FIRST_HOST;

        log.info(bucketName);

        String uploadUrl = null;

        OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);


        try {
            // 判断Bucket是否存在。详细请参看“SDK手册 > Java-SDK > 管理Bucket”。
            // 链接地址是：https://help.aliyun.com/document_detail/oss/sdk/java-sdk/manage_bucket.html?spm=5176.docoss/sdk/java-sdk/init
            if (ossClient.doesBucketExist(bucketName)) {
                System.out.println("您已经创建Bucket：" + bucketName + "。");
            } else {
                System.out.println("您的Bucket不存在，创建Bucket：" + bucketName + "。");
                // 创建Bucket。详细请参看“SDK手册 > Java-SDK > 管理Bucket”。
                // 链接地址是：https://help.aliyun.com/document_detail/oss/sdk/java-sdk/manage_bucket.html?spm=5176.docoss/sdk/java-sdk/init
                ossClient.createBucket(bucketName);
                //设置Bukcet权限
                ossClient.setBucketAcl(bucketName, CannedAccessControlList.PublicRead);

            }

            //设置输入流
            InputStream is = file.getInputStream();

            String filePath = new DateTime().toString("yyyy-MM-dd");

            //文件名：UUID+扩展名
            String fileNamePrefix = UUID.randomUUID().toString();
            String originalFilename = file.getOriginalFilename();
            String fileType = originalFilename.substring(originalFilename.lastIndexOf("."));
            String fileName = fileNamePrefix + fileType;
            String fileUrl = firstHost + "/" + filePath + "/" + fileName;

            //上传文件到阿里云
            ossClient.putObject(bucketName, fileUrl, is);

            //关闭服务
            ossClient.shutdown();

            uploadUrl = "https://" + bucketName + "." + endpoint +"/" + fileUrl;

        } catch (Exception e) {
            throw new GuliException(ResultCodeEnum.FILE_UPLOAD_ERROR);
        }

        return uploadUrl;
    }
}
