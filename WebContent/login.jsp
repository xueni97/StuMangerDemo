<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/myStyle.css">
<title>登陆界面</title>
</head>
<body>

<div align="center" class="mid">
<%if(request.getAttribute("error")!=null){
	out.print("<strong>增加失败</strong>");
} %>
<form action="LoginServlet" method="post">
<h1>用户名：<input type="text" name="uname"/><br/></h1>
<h1>密 	 码：<input type="password" name="upwd"/><br/></h1>
<h1><input type="submit" value="登陆" front-size="20px"/></form></h1>
</div>
</body>
</html>