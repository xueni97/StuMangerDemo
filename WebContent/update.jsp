<%@page import="java.util.List"%>
<%@page import="mo.service.StudentService"%>
<%@page import="mo.entity.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<% 
Student stu=(Student)request.getAttribute("stu");
//Student stu=new Student();
//StudentService stuservice=new StudentService();
//stuservice.findStudentByStuNo(stu.getStuNo());

%>

<div align="center">
<form action="UpdateStuByNoServlet" method="post">

<h2>修改学生信息</h2>
<% out.print(stu);%><br/>
学 号：<input type="text" name="StuNo" value="<%=stu.getStuNo()%>"/><br/>
姓 名：<input type="text" name="StuName" value="<%=stu.getStuName()%>"/><br/>
年 龄：<input type="text" name="StuAge" value="<%=stu.getStuAge()%>"/><br/>
年 级：<input type="text" name="gName" value="<%=stu.getgName()%>"/><br/>
<input type="submit" value="修改">
</form>
</div>
<a href="QuerAllStudentServlet">返回学生信息页</a>

</body>
</html>