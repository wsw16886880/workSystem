package com.worksystem.utils;

import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import javax.servlet.ServletContext;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @author wsw16
 */
public class UploadUtils {
    /**
     * 获取上下文对象
     */
    private ServletContext servletContext;
    /**
     * 上传文件对象
     */
    private MultipartFile file;
    /**
     * 文件存储的文件夹名称，字符串末带有 /
     */
    private String uploadPath = "";
    /**
     * 获取应用根路径
     */
    private String serverPath;

    public UploadUtils(ServletContext servletContext, MultipartFile file, String uploadPath) {
        this.servletContext = servletContext;
        this.file = file;
        this.uploadPath = uploadPath;
        this.serverPath = servletContext.getRealPath("/");
    }

    /**
     * 保存上传的文件，如果有重复直接覆盖
     * 返回保存的文件名称，可用 file.getOriginalFilename() 获取
     * @return endFileName
     */
    public Map<String, String> upload() {
        Map<String, String> endFileName = new HashMap<String, String>();
        // 创建文件夹
        File fileDir = new File(serverPath + uploadPath);
        if (!fileDir.exists()) {
            fileDir.mkdirs();
        }
        // 获取文件后缀
        String suffix = getFileSuffix(file.getOriginalFilename());
        // 生成随机名称
        String prefix = getUUIDName();
        // 保存文件
        if (saveFile(prefix, suffix)) {
            // 添加名称
            endFileName.put(file.getOriginalFilename(), prefix + "." + suffix);
        }
        return endFileName;
    }

    /**
     * 保存文件
     *
     * @param prefix
     * @param suffix
     * @return
     */
    private boolean saveFile(String prefix, String suffix) {
        String endFileName = null;
        try {
            // 生成文件保存最终路径
            endFileName = serverPath + uploadPath + prefix + "." + suffix;
            // 存储文件
            file.transferTo(new File(endFileName));
            return true;
        } catch (IOException e) {
            System.out.println("保存文件失败！！");
            System.out.println("文件保存最终路径=" + endFileName);
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 删除文件，基于已传入 uploadPath 目标存储的文件夹名称
     *
     * @param fileName
     */
    public void deleteFile(String fileName) {
        File oldFile = new File(serverPath + uploadPath + fileName);
        oldFile.delete();
    }

    /**
     * 删除文件
     *
     * @param fileName
     *            ：提供所要删除的文件名称(如：355656dfrre.jpg)
     * @param uri 文件所在路径（如：项目名称/file）
     */
    public static void deleteFile(String fileName, String uri) {
        File file = new File(uri + "/" + fileName);
        file.delete();
    }

    /**
     * 删除文件夹
     * @param file：提供要删除的文件夹File对象
     * @return
     */
    public static boolean recurisonDeleteFile(File file) {
        // 判断文件是否存在
        if (!file.exists()) {
            return false;
        }
        // 判断文件是不是文件
        if (!file.isFile()) {
            // 文件是一个目录
            // 获取目录中的文件和目录
            File[] files = file.listFiles();
            for (File file1 : files) {
                recurisonDeleteFile(file1);
            }
        }
        // 删除文件
        // 文件是标准文件
        return file.delete();
    }

    /**
     * 获取文件后缀
     *
     * @param fileName
     * @return
     */
    public String getFileSuffix(String fileName) {
        return fileName.substring(file.getOriginalFilename().lastIndexOf(".") + 1);
    }

    /**
     * 生成 UUID
     *
     * @return
     */
    public String getUUIDName() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    /**
     * 判断文件类型
     * 目前支持的文件类型：image
     * @param fileInputStream
     * @param type
     * @return
     */
    public boolean isImageType(InputStream fileInputStream, String type) {
        if (type.equals("image")) {
            try {
                // 判断文件类型是否为 图片
                BufferedImage bi = ImageIO.read(fileInputStream);
                // 可能会有漏洞，原因：不了解判断流的原理
                if (bi == null) {
                    System.err.println("上传的不是图片");
                    return false;
                }
                return true;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return false;
    }
}
