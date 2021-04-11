package com.chris.question.common.utils;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.UUID;

public class UploadUtils {

    private final static String IMG_PATH_PREFIX = "src/main/resources/statics/upload/img";

     static {
        File fileDir = new File(IMG_PATH_PREFIX);
        if (!fileDir.exists()) {
            fileDir.mkdirs();
        }
    }

    private static String getFileType(MultipartFile file){
        String originalFileName = file.getOriginalFilename();
        return originalFileName.substring(originalFileName.lastIndexOf(".") + 1);
    }

    private static String getFileName(MultipartFile file){
        String originalFileName = file.getOriginalFilename();
        return originalFileName.substring(0, originalFileName.lastIndexOf("."));
    }

    public static String createUniqueFileName(MultipartFile file){
        return UUID.randomUUID() + getFileName(file) + "." + getFileType(file);
    }

    public static FileResult upload(MultipartFile file,String uniqueFileName){
        File target = new File(IMG_PATH_PREFIX,uniqueFileName);
        try {
            byte[] bytes = file.getBytes();
            OutputStream out = new FileOutputStream(target);
            out.write(bytes);

            return new FileResult(true,uniqueFileName,IMG_PATH_PREFIX + "/" + uniqueFileName);
        }catch (IOException e){
            System.out.println(e.getMessage());
            return new FileResult(false, "上传失败","");
        }
    }

    public static String getBackFile(HttpServletResponse res,String path){
        try{
            FileInputStream in = new FileInputStream(path);
            int i = in.available();
            byte[] bytes = new byte[i];
            int read = in.read(bytes);
            in.close();

            res.setContentType("image/*");
            OutputStream out = res.getOutputStream();
            out.write(bytes);
            out.close();

            return "success";
        }catch (Exception e){
            System.out.println(e.getMessage());
            return "error";
        }
    }
}
