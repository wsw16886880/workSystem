package com.worksystem.controller.home;

import com.alibaba.fastjson.JSON;
import com.worksystem.entity.*;
import com.worksystem.service.MessageService;
import com.worksystem.utils.HTMLUtils;
import com.worksystem.utils.HttpsRequestUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author wsw16
 */
@Controller
@RequestMapping("/EducationCenter")
public class HomeMessageController {

    private final MessageService messageService;

    @Autowired
    public HomeMessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @PostMapping("/messageAdd")
    public String messageAdd(ModelMap modelMap, @CookieValue("cksgid") Integer mgid, @CookieValue("cksid") Integer msid, Integer wid, String mcontent) {
        // 封装数据
        Message message = new Message();
        message.setMcontent(mcontent);
        message.setMgid(mgid);
        message.setMsid(msid);
        message.setMwid(wid);
        message.setMtime(new Date());

        // 连接数据库，添加留言
        int result = messageService.insert(message);

        // 判断添加是否成功
        if (result > 0) {
            return HTMLUtils.success(modelMap, "留言成功", "work?wid=" + wid);
        } else {
            return HTMLUtils.error(modelMap, "留言失败");
        }
    }

    @PostMapping("/wxmessageAdd")
    @ResponseBody
    public JsonResult wxmessageAdd(Integer sid, Integer gid, Integer wid, String mcontent) throws Exception {
        JsonResult jsonResult = new JsonResult();

        // 检测文本是否包含违规内容
        // 1.获取接口调用凭证：access_token= GET https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET
        String appid = "wx5b892277a6d2ab02";
        String appsecret = "d55b2271784ab75e344f1ec0f13c4aa9";
        String requestAccessUrl = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid="
                + appid
                + "&secret="
                + appsecret;
        String getResult = HttpsRequestUtil.HttpsRequest(requestAccessUrl, "GET", null);
        WXAccessToken wxAccessToken = JSON.parseObject(getResult, WXAccessToken.class);
        // 1.1 判断数据是否获取成功
        if (wxAccessToken.getErrcode() == 0) {
            // 获取成功
            // 2.调用该接口 POST https://api.weixin.qq.com/wxa/msg_sec_check?access_token=ACCESS_TOKEN
            String requestMsgCheckUrl = "https://api.weixin.qq.com/wxa/msg_sec_check?access_token="
                    + wxAccessToken.getAccess_token();
            // 设置请求参数
            Map<String, String> paramsMap = new HashMap<>();
            paramsMap.put("content", mcontent);
            String request = HttpsRequestUtil.httpRequest(requestMsgCheckUrl, "POST", paramsMap);
            WXMsgSecCheck wxMsgSecCheck = JSON.parseObject(request, WXMsgSecCheck.class);

            // 判断文本是否含有违法违规内容
            if (wxMsgSecCheck.getErrcode() == 0) {
                // 检查通过

                // 封装数据
                Message message = new Message();
                message.setMcontent(mcontent);
                message.setMgid(gid);
                message.setMsid(sid);
                message.setMwid(wid);
                message.setMtime(new Date());

                // 连接数据库，添加留言
                int result = messageService.insert(message);


                // 判断添加是否成功
                if (result > 0) {
                    jsonResult.setCode(0);
                } else {
                    jsonResult.setCode(-1);
                    jsonResult.setData("添加失败！");
                }
            } else {
                // 涉及违规内容，检查不通过
                jsonResult.setCode(87014);
                jsonResult.setMessage("评论内容涉及敏感信息！");
            }
        } else {
            Log log = LogFactory.getLog(Log.class);
            log.info("获取AccessToken失败，错误信息：" + wxAccessToken.getErrcode() + "；" + wxAccessToken.getErrmsg());
            // 获取失败
            jsonResult.setCode(-1);
            jsonResult.setData("服务器出了小问题，评论失败！");
        }

        return jsonResult;
    }

    /**
     * jsonp格式
     * JSONPObject jsonp = new JSONPObject(callback, pageSet);
     * return jsonp;
     * @param wid
     * @param pno
     * @return
     */
    @RequestMapping("/messageList")
    @ResponseBody
    public JsonResult messageList(Integer wid, Integer pno) {
        JsonResult jsonResult = new JsonResult();
        // 开始分页
        PageSet pageSet = messageService.selectMoreTableByWidToPageSet(wid, pno, 5);
        jsonResult.setCode(0);
        jsonResult.setData(pageSet);
        return jsonResult;
    }
}
