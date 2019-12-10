package com.programmingroad.blog.utils;

import org.springframework.util.StreamUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;

/**
 * @author: baoqi.liu
 * @create: 2019/12/10 11:14
 * @description:
 * @version: 1.0
 **/
public class Base64Util {

    public static String encoder(byte[] body) {
        return Base64.getEncoder().encodeToString(body);
    }

    public static byte[] decoder(String base64) {
        return Base64.getDecoder().decode(base64);
    }

    public static String fileToBase64(File file) throws IOException {
        return encoder(fileToBody(file));
    }

    public static byte[] fileToBody(File file) throws IOException {
        try (InputStream is = new FileInputStream(file)) {
            return StreamUtils.copyToByteArray(is);
        }
    }
}
