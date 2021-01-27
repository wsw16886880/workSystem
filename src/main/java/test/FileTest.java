package test;

import com.alibaba.fastjson.JSON;
import com.worksystem.entity.WXAccessToken;
import com.worksystem.utils.HttpsRequestUtil;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class FileTest {
    @Test
    public void demo1() {
        // 文件夹
        String fileDir = "H:\\test";
        // 递归删除文件夹
        File file = new File(fileDir);
        boolean b = recurisonDeleteFile(file);
        System.out.println(b);
    }

    @Test
    public void demo2() {
        String fileDir = "H:\\test";
        File file = new File(fileDir);
        String[] list = file.list();
        System.out.println(list);
        List<String> stringList = new ArrayList<>();
        for (String s : list) {
            stringList.add(s);
        }

        String tempUri = "1.txt";
        boolean contains = stringList.contains(tempUri);
        System.out.println(contains);
    }

    public boolean recurisonDeleteFile(File file) {
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

    @Test
    public void demo3() throws IOException {
        // 文件夹
        String fileDir = "H:\\test.zip";
        // 创建文件夹
        File file = new File(fileDir);

        // 判断文件夹是否存在
//        if (!file.exists()) {
        file.createNewFile();
//        }
    }

    @Test
    public void demo4() {
//        WebApplicationContext web = ContextLoader.getCurrentWebApplicationContext()
//        ServletContext servletContext = web.getServletContext();
//        String zipBasePath = servletContext.getRealPath("/zip");
//        System.out.println(zipBasePath);
    }

    @Test
    public void demo5() throws IOException {
        String appid = "wx5b892277a6d2ab02";
        String appsecret = "d55b2271784ab75e344f1ec0f13c4aa9";
        String requestAccessUrl = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid="
                + appid
                + "&secret="
                + appsecret;
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(requestAccessUrl);
        CloseableHttpResponse httpResponse = httpClient.execute(httpGet);
        // 将从微信服务器获取到的信息转换为实体类
        String result = EntityUtils.toString(httpResponse.getEntity());
        WXAccessToken wxAccessToken = JSON.parseObject(result, WXAccessToken.class);
        System.out.println(wxAccessToken.getErrcode());
        System.out.println(wxAccessToken.getAccess_token());

        // 检查数据
        String requestMsgCheckUrl = "https://api.weixin.qq.com/wxa/msg_sec_check?access_token="
                + wxAccessToken.getAccess_token();
        HttpPost httpPost = new HttpPost(requestMsgCheckUrl);
        List<NameValuePair> parameters = new LinkedList();
        BasicNameValuePair param1 =
                new BasicNameValuePair("content", "特3456书yuuo莞6543李zxcz蒜7782法fgnv级");
        BasicNameValuePair param2 =
                new BasicNameValuePair("content", "完2347全dfji试3726测asad感3847知qwez到");
        parameters.add(param1);
        UrlEncodedFormEntity entity = new UrlEncodedFormEntity(parameters, "UTF-8");
        HashMap<String, Object> stringObjectHashMap = new HashMap<>();
        stringObjectHashMap.put("content", "阿斯顿发顺丰撒旦法撒旦法撒的发顺丰水电费和健身房和接口");
        String sMap = JSON.toJSONString(stringObjectHashMap);
        StringEntity stringEntity = new StringEntity(sMap, ContentType.create("text/json", "UTF-8"));

        httpPost.setEntity(stringEntity);
        CloseableHttpResponse execute = httpClient.execute(httpPost);
        String check = EntityUtils.toString(execute.getEntity());
        Map map = JSON.parseObject(check, Map.class);
        System.out.println(map);

    }

    @Test
    public void demo6(){
        String appid = "wx5b892277a6d2ab02";
        String appsecret = "d55b2271784ab75e344f1ec0f13c4aa9";
        String requestAccessUrl = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid="
                + appid
                + "&secret="
                + appsecret;
        String get = HttpsRequestUtil.httpRequest(requestAccessUrl, "get", null);
        WXAccessToken wxAccessToken = JSON.parseObject(get, WXAccessToken.class);

        String requestMsgCheckUrl = "https://api.weixin.qq.com/wxa/msg_sec_check?access_token="
                + wxAccessToken.getAccess_token();
        // 设置请求参数
        Map<String, String> paramsMap = new HashMap<>();
        paramsMap.put("content", "阿士大夫撒地方撒地方撒打发斯蒂芬士大夫");
        String post = HttpsRequestUtil.httpRequest(requestMsgCheckUrl, "POST", paramsMap);
        Map map = JSON.parseObject(post, Map.class);
        System.out.println(map);
    }
}
