package com.worksystem.utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class CookieUtils {

	public static void addCookie(String ckName, String ckValue,
			HttpServletResponse response) throws UnsupportedEncodingException {
		Cookie cookie = new Cookie(ckName, URLEncoder.encode(ckValue, "UTF-8"));
		response.addCookie(cookie);
	}
	public static void addCookie(String ckName, String ckValue,int day,
			HttpServletResponse response) throws UnsupportedEncodingException {
		Cookie cookie = new Cookie(ckName, URLEncoder.encode(ckValue, "UTF-8"));
		cookie.setMaxAge(3600*24*day);
		response.addCookie(cookie);
	}

	public static String getCookie(String ckName, HttpServletRequest request)
			throws UnsupportedEncodingException {
		Cookie cookies[] = request.getCookies();
		String value = "";
		if (cookies != null) {
			for (int i = 0; i < cookies.length; i++) {
				Cookie cookie = cookies[i];
				if (cookie.getName().equalsIgnoreCase(ckName)) {
					value = cookie.getValue();
					break;
				}
			}
		}
		return URLDecoder.decode(value, "UTF-8");
	}

	public static void clear(HttpServletResponse response,HttpServletRequest request){
		Cookie[] cookies=request.getCookies();
		for(Cookie cookie: cookies){
			cookie.setMaxAge(0);
			response.addCookie(cookie);
			}
	}
}
