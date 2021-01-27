package com.worksystem.utils;

import com.alibaba.fastjson.JSON;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import java.io.*;
import java.net.URL;
import java.util.Map;

public class HttpsRequestUtil {
	public static  String HttpsRequest(String requestUrl,String requestMethod,String outStr) throws Exception{

		//建立连接

		//	      创建	SSLContext
		SSLContext  sslContext=SSLContext.getInstance("SSL","SunJSSE");
		TrustManager[]tm={new MyX509TrustManager()};
//			初始化
		sslContext.init(null, tm, new java.security.SecureRandom());
//			获取sslSOCKETfactory对象
		SSLSocketFactory ssf=sslContext.getSocketFactory();


//设置当前实例使用sslSOCKETfactory
		StringBuffer buffer=null;
		URL url=new URL(requestUrl);
		HttpsURLConnection conn=(HttpsURLConnection)url.openConnection();


		conn.setRequestMethod(requestMethod);
		conn.setDoOutput(true);
		conn.setDoInput(true);
		conn.setSSLSocketFactory(ssf);
		conn.connect();

		if(outStr!=null){

			OutputStream os=conn.getOutputStream();
			os.write(outStr.getBytes("UTF-8"));
			os.close();

		}


//		读取服务端的内容
		InputStream is=conn.getInputStream();
		InputStreamReader isr=new InputStreamReader(is,"utf-8");
		BufferedReader br=new BufferedReader(isr);
		buffer=new StringBuffer();
		String line=null;
		while((line=br.readLine())!=null){
			buffer.append(line);
		}

//打印数据

		System.out.println( buffer.toString());


		return buffer.toString();


	}

	public static String httpRequest(String requestUrl, String requestMethod, Map paramsMap){
		HttpGet httpGet;
		HttpPost httpPost;
		CloseableHttpResponse execute;

		// 创建客户端
		CloseableHttpClient httpClient = HttpClients.createDefault();
		if (requestMethod.equalsIgnoreCase("post")) {
			// 创建post请求
			httpPost = new HttpPost(requestUrl);
			// 添加post的json参数
			// 将map参数转换成json
			String sMap = JSON.toJSONString(paramsMap);
			// 添加json参数到Entity中
			StringEntity stringEntity = new StringEntity(sMap, ContentType.create("text/json", "UTF-8"));
			// 设置参数
			httpPost.setEntity(stringEntity);

			// 发送请求
			try {
				execute = httpClient.execute(httpPost);
			} catch (IOException e) {
				e.printStackTrace();
				System.out.println("请求失败");
				return null;
			}
		} else {
			httpGet = new HttpGet(requestUrl);
			// 发送请求
			try {
				execute = httpClient.execute(httpGet);
			} catch (IOException e) {
				e.printStackTrace();
				System.out.println("请求失败");
				return null;
			}
		}

		// 解析response成字符串
		String check = null;
		try {
			check = EntityUtils.toString(execute.getEntity());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return check;
	}
}
