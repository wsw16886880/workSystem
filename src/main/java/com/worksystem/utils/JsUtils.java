package com.worksystem.utils;

import javax.servlet.jsp.JspWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class JsUtils {
	public static void  jsBack(JspWriter out,String msg) throws IOException{
		out.println("<script language='javascript'>alert('"+msg+"');history.back();</script>");
	}
	public static void  jsGo(PrintWriter out,String msg,String url) throws IOException{
		out.println("<script language='javascript'>alert('"+msg+"');location.href='"+url+"';</script>");
	}
	
}
