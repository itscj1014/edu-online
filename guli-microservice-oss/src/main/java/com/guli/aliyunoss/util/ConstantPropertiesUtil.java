package com.guli.aliyunoss.util;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ConstantPropertiesUtil implements InitializingBean {

    @Value("${aliyun.oss.file.endpoint}")
    private String endpoint;
    @Value("${aliyun.oss.file.keyid}")
    private String keyId;
    @Value("${aliyun.oss.file.keysecret}")
    private String keyScret;
    @Value("${aliyun.oss.file.bucketname}")
    private String bucketName;
    @Value("${aliyun.oss.file.firsthost}")
    private String firtHost;

    public static String END_POINT;
    public static String ACCESS_KEY_ID;
    public static String ACCESS_KEY_SCRET;
    public static String BUCKET_NAME;
    public static String FIRST_HOST;

    @Override
    public void afterPropertiesSet() throws Exception {
        END_POINT = endpoint;
        ACCESS_KEY_ID = keyId;
        ACCESS_KEY_SCRET = keyScret;
        BUCKET_NAME = bucketName;
        FIRST_HOST = firtHost;
    }
}
