<%@page import="javax.naming.InitialContext"%>
<%@page import="javax.naming.Context"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<a href="DownLoadFileServlet?fileName=泵机.jpg">文件先下载</a>
<%
Context cxt=new InitialContext();
//java:comp/env/为固定前缀
String name=(String)cxt.lookup("java:comp/env/uname");
//String =(String)cxt.lookup("java:comp/env/name");
out.print("JDIN:"+name);
%>
</body>
</html>