

<%@page import="mo.service.StudentService"%>
<%@page import="mo.entity.Student"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div align="center">
<% List<Student> stus =(List<Student>)request.getAttribute("stus"); %>
<table border="1" width="80%" >
<caption>学生信息表</caption>
<tr>
	<th>学号</th><th>姓名</th><th>年龄</th><th>年级</th><th>操作</th>
</tr>
<%
if( stus != null){
	for(int i =0;i<stus.size();i++){
		out.print("<tr>");
		out.print("<td>"+stus.get(i).getStuNo()+"</td>");
		out.print("<td>"+stus.get(i).getStuName()+"</td>");
		out.print("<td>"+stus.get(i).getStuAge()+"</td>");
		out.print("<td>"+stus.get(i).getgName()+"</td>");
		out.print("<td><a href='DelByStuNoServlet?StuNo="+stus.get(i).getStuNo()+"'>删除</a><a href='findStudentByStuNoServlet?StuNo="+stus.get(i).getStuNo()+"'>修改</a></td>");
		out.print("</tr>");
		
	}
}else{
out.println("学生没传进来");
request.getRequestDispatcher("fail.jsp").forward(request, response);
}
//<a href='AddStudentServlet?stuNo="+stus.get(i).getStuNo()+"'>增加</a>
 /*if( stus == null){
	for(int i =0;i<stus.size();i++){
		out.print("<tr>");
		out.print("<td>"+stus.get(i).getStuNo()+"</td>");
		out.print("<td>"+stus.get(i).getStuName()+"</td>");
		out.print("<td>"+stus.get(i).getStuAge()+"</td>");
		out.print("<td>"+stus.get(i).getgName()+"</td>");
		out.print("<td><a href='DelByStuNoServlet?stuNo="+stus.get(i).getStuNo()+"'>删除</a><a href='UpdateStuByNo?stuNo="+stus.get(i).getStuNo()+"'>修改</a><a href='AddStudent?stuNo="+stus.get(i).getStuNo()+">增加</a></td>");
		out.print("</tr>");
		out.print("yes");
	}
}
	
	}else{
	out.print("输出学生信息失败");
}
*/

%>
</table>
<a href="addStudent.jsp">增加学生</a>
</div>
</body>
</html>