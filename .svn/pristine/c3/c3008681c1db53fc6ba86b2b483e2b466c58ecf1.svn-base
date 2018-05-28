<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>增加学生</title>
</head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<body>

<%
if(request.getAttribute("error")!=null){
	out.print("<strong>增加失败</strong>");
}
%>
<form action="AddStudentServlet" method="post">
学 号：<input type="text" name="StuNo"/><br/>
姓 名：<input type="text" name="StuName"/><br/>
年 龄：<input type="text" name="StuAge"/><br/>
年 级：<input type="text" name="gName"/><br/>
<input type="submit" value="增加"/><br/>
</form>
</body>
</html>