package com.worksystem.utils;

import com.worksystem.entity.Late;

import javax.servlet.ServletContext;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * @author wsw16
 */
public class DownloadUtils {
    private ServletContext servletContext;

    public DownloadUtils() {
    }

    public DownloadUtils(ServletContext servletContext) {
        this.servletContext = servletContext;
    }

    /**
     *
     * 创建要下载的zip文件
     * 返回zip文件全路径
     *
     * @param lates
     * @param filePaths
     * @param fileNames
     * @param stuNum
     * @return
     */
    public String downloadZip(List<Late> lates, List<String> filePaths,
                              Map<String, String> fileNames, Map<String, String> stuNum) throws IOException {
        // 2.创建zip文件需要空的zip包，设置zip压缩包路径
        String zipBasePath = servletContext.getRealPath("/zip");
        File tempZipFile = new File(zipBasePath);
        tempZipFile.mkdir();
        String zipName = UUID.randomUUID()+".zip";
        String zipFilePath = zipBasePath + File.separator + zipName;
        // 3.创建需要下载的文件的集合，数据从页面传过来
        // 4.创建压缩文件，类似中转站，现在服务器压缩好，然后将这个压缩文件传给页面下载，下载过一次后，服务器始终会存在一个压缩文件
        try {
            File zip = new File(zipFilePath);
            if (zip.exists()) {
                // 存在就删除
                zip.delete();
            }
            // 创建文件
            zip.createNewFile();

            // 5.创建压缩文件输出流，此时已经完成所以文件的压缩
            ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(zip));
            // 将要压缩的文件路径压缩进zip文件中
            zipFile(zipBasePath, zipName, zipFilePath, filePaths, fileNames, stuNum,
                    zos);
            zos.close();

            // 6.输出zip文件路径
            return zipFilePath;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 压缩文件
     *
     * @param zipBasePath
     *            临时压缩文件基础路径
     * @param zipName
     *            临时压缩文件名称
     * @param zipFilePath
     *            临时压缩文件完整路径
     * @param filePaths
     *            需要压缩的文件路径集合
     * @param fileNames
     * @param stuNum
     * @throws IOException
     */
    public String zipFile(String zipBasePath, String zipName,
                          String zipFilePath, List<String> filePaths,
                          Map<String, String> fileNames, Map<String, String> stuNum, ZipOutputStream zos)
            throws IOException {

        // 循环读取文件路径集合，获取每一个文件的路径
        for (String filePath : filePaths) {
            // 根据文件路径创建文件
            File inputFile = new File(filePath);
            // 判断文件是否存在
            if (inputFile.exists()) {
                // 判断是否属于文件，还是文件夹
                if (inputFile.isFile()) {
                    // 创建输入流读取文件
                    BufferedInputStream bis = new BufferedInputStream(
                            new FileInputStream(inputFile));

                    // 将文件写入zip内，即将文件进行打包。文件名：学号后两位+姓名+后缀
                    zos.putNextEntry(new ZipEntry(stuNum.get(inputFile.getName()) + fileNames.get(inputFile
                            .getName()) + getSuffix(inputFile.getName())));

                    // 写入文件的方法，同上
                    int size = 0;
                    // 设置读取数据缓存大小
                    byte[] buffer = new byte[1024];
                    while ((size = bis.read(buffer)) > 0) {
                        zos.write(buffer, 0, size);
                    }
                    // 关闭输入输出流
                    zos.closeEntry();
                    bis.close();
                } else { // 如果是文件夹，则使用穷举的方法获取文件，写入zip
                    try {
                        File[] files = inputFile.listFiles();
                        List<String> filePathsTem = new ArrayList<String>();
                        for (File fileTem : files) {
                            filePathsTem.add(fileTem.toString());
                        }
                        return zipFile(zipBasePath, zipName, zipFilePath,
                                filePathsTem, fileNames, stuNum, zos);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return null;
    }

    public static String getSuffix(String filename) {
        // 获取后缀
        int index = filename.lastIndexOf(".");
        String suffix = filename.substring(index);
        return suffix;
    }
}
