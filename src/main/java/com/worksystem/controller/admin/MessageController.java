package com.worksystem.controller.admin;

import com.worksystem.entity.Admin;
import com.worksystem.service.MessageService;
import com.worksystem.utils.HTMLUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

/**
 * @author wsw16
 */
@Controller
@RequestMapping("/admin")
@SessionAttributes("admin")
public class MessageController {
    private final MessageService messageService;

    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @GetMapping("/messageList")
    public String messageList(ModelMap modelMap, @RequestParam(value = "wid", defaultValue = "-1") Integer wid, @SessionAttribute(value = "admin", required = false) Admin admin) {
        // 判断是否为单个作业的查询
        if (wid == -1) {
            // 判断登录账号类型，判断是哪个班级的学委
            if (admin.getAgid() == 0) {
                modelMap.addAttribute("messages", messageService.selectAllMoreTable());
            } else {
                modelMap.addAttribute("messages", messageService.selectMoreTableByGid(admin.getAgid()));
            }
        } else {
            modelMap.addAttribute("messages", messageService.selectFewTableExampleByWid(wid));
        }
        return "/admin/message";
    }

    @GetMapping("/messageDelete")
    public String messageDelete(ModelMap modelMap, Integer mid) {
        //连接数据库，删除数据
        int result = messageService.deleteByPrimaryKey(mid);
        // 判断数据是否添加成功
        if (result > 0) {
            return HTMLUtils.success(modelMap, "删除成功！", "form");
        } else {
            return HTMLUtils.error(modelMap, "删除失败！");
        }
    }
}
