 package mo.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mo.entity.Student;
import mo.service.StudentService;


public class AddStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
//		接受表单数据
		int StuNo=Integer.parseInt(request.getParameter("StuNo"));
		String StuName=request.getParameter("StuName");
		System.out.println(StuName);
		int StuAge=Integer.parseInt(request.getParameter("StuAge"));
		String gName=request.getParameter("gName");
//		将数据封装到实体类
//		Student stu=new Student(StuNo,StuName,StuAge,gName);
		Student stu=new Student();
		stu.setStuNo(StuNo);
		stu.setStuName(StuName);
		stu.setStuAge(StuAge);
		stu.setgName(gName);
		//request.setAttribute("stu", stu);
//		调用业务逻辑层代码
		
		StudentService stuservice=new StudentService();
		boolean flag=false;
		flag=stuservice.AddStudent(stu);
		System.out.println(flag);
		if (!flag) {
			System.out.println("增加失败");
//			如果增加失败在request放入标识符，表示错误
			request.setAttribute("addError", "error");
//			返回增加页面，因为需要传递request作用域数据，所以使用请求转发
//			request.getRequestDispatcher("fail.jsp").forward(request, response);
			request.getRequestDispatcher("addStudent.jsp").forward(request, response);
		}else {
			System.out.println("增加成功！来自AddStudentServlet");
			
			//request.getRequestDispatcher("succeed.jsp").forward(request, response);
			request.setAttribute("stu", stu);
//			response.sendRedirect("succeed.jsp");
			request.getRequestDispatcher("succeed.jsp").forward(request, response);
//			response.sendRedirect("QuerAllStudentServlet");
		}
		
	}

}
