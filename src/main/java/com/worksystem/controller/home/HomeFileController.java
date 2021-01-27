package com.worksystem.controller.home;

import com.worksystem.entity.Late;
import com.worksystem.entity.Work;
import com.worksystem.service.LateService;
import com.worksystem.service.WorkService;
import com.worksystem.utils.DownloadUtils;
import com.worksystem.utils.HTMLUtils;
import com.worksystem.utils.UploadUtils;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.Date;
import java.util.Map;

/**
 * @author wsw16
 */
@Controller
@RequestMapping("/EducationCenter")
public class HomeFileController {

    private final LateService lateService;

    private final WorkService workService;

    @Autowired
    public HomeFileController(LateService lateService, WorkService workService) {
        this.lateService = lateService;
        this.workService = workService;
    }

    /**
     * 第一次上交作业
     * @param modelMap
     * @param zuoye
     * @param session
     * @param sid
     * @param late
     * @return
     */
    @PostMapping("/file")
    public String file(ModelMap modelMap, @RequestParam("zuoye") MultipartFile zuoye, HttpSession session, Integer sid, Late late) {
        if(zuoye == null || zuoye.isEmpty()) {
            return HTMLUtils.error(modelMap, "不能上传空文件！");
        }

        // 获取要保存的文件路径：workfiles/周/wid/文件名称
        String fileDir = "/WEB-INF/workfiles/" + late.getLweek() + File.separatorChar + late.getLwid() + File.separatorChar;
        // 创建文件上传工具对象
        UploadUtils uploadUtils = new UploadUtils(session.getServletContext(), zuoye, fileDir);
        // 保存上传文件
        Map<String, String> path = uploadUtils.upload();

        // 封装对象
        late.setLedate(new Date());
        late.setLsid(sid);
        late.setLfile(path.get(zuoye.getOriginalFilename()));
        late.setIssubmit("是");

        // 更改数据
        int result = lateService.updateByLsidAndLweekAndLwid(late);
        result += workService.updateWtotal(late.getLwid());
        if (result > 1) {
            return HTMLUtils.success(modelMap, "上传成功！", "toworkList");
        }
        return "/EducationCenter/Objection";
    }

    /**
     * 重新提交作业
     * @return
     */
    @PostMapping("/resubmitFile")
    public String resubmitFile(ModelMap modelMap, @RequestParam("zuoye") MultipartFile zuoye, HttpSession session, Integer sid, Late late) {
        if(zuoye == null || zuoye.isEmpty()) {
            return HTMLUtils.error(modelMap, "不能上传空文件！");
        }

        // 最大上传：10MB
        try {
            if(zuoye.getBytes().length > 10485760) {
                return HTMLUtils.error(modelMap, "最大只能上传10M的文件！");
            }
        } catch (IOException e) {
            e.printStackTrace();
            return HTMLUtils.error(modelMap, "上传文件错误！");
        }

        // 获取要保存的文件路径：workfiles/周/wid/文件名称
        String fileDir = "/WEB-INF/workfiles/" + late.getLweek() + File.separatorChar + late.getLwid() + File.separatorChar;
        // 创建文件上传工具对象
        UploadUtils uploadUtils = new UploadUtils(session.getServletContext(), zuoye, fileDir);
        // 保存上传文件
        Map<String, String> path = uploadUtils.upload();

        // 封装对象
        late.setLedate(new Date());
        late.setLsid(sid);
        late.setLfile(path.get(zuoye.getOriginalFilename()));
        late.setIssubmit("是");

        // 删除之前提交的文件
        String fileName = lateService.getFileName(late);
        uploadUtils.deleteFile(fileName);

        // 更改数据
        int result = lateService.updateByLsidAndLweekAndLwid(late);
        result += workService.updateWtotal(late.getLwid());
        if (result > 1) {
            return HTMLUtils.success(modelMap, "上传成功！", "toworkList");
        }
        return "/EducationCenter/Objection";
    }

    @GetMapping("/download")
    public ResponseEntity<byte[]> downloadSource(Integer wid, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        // 获取去servletContext上下文对象
        WebApplicationContext webApplicationContext = ContextLoader.getCurrentWebApplicationContext();
        ServletContext servletContext = webApplicationContext.getServletContext();

        // 获取文件名称
        Work work = workService.selectByPrimaryKey(wid);
        // 判断是否有上传源文件
        if (work.getWfile() == null) {
            HTMLUtils.error(request, response, "无文件下载");
            return null;
        }

        // 文件下载路径
        String fileDownloadPath = servletContext.getRealPath("/sourcefile")+File.separatorChar + work.getWfile();
        File file = new File(fileDownloadPath);

        // 获取文件后缀
        String suffix = DownloadUtils.getSuffix(work.getWfile());

        // 响应头
        HttpHeaders headers = new HttpHeaders();
        // 设置响应方式
        headers.setContentType(MediaType.valueOf(servletContext.getMimeType(work.getWfile())));
        // 设置响应文件
        headers.setContentDispositionFormData("attachment", URLEncoder.encode(work.getWname()+suffix, "utf-8"));
        return new ResponseEntity<>(FileUtils.readFileToByteArray(file), headers, HttpStatus.CREATED) ;
    }
}
