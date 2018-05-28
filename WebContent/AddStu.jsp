<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>上传</title>
</head>
<body>
<form action="AddStuServlet" enctype="multipart/form-data" method="post">
学号：<input type="text" name="StuNo"/><br/>
姓名：<input type="text" name="StuName"/><br/>
年龄：<input type="text" name="StuAge"/><br/>
年级<input type="text" name="gName"/><br/>
上传照片：<input type="file" name="StuPic"/><br/>
<input type="submit" value="增加"/><br/>
</form>
</body>
</html>