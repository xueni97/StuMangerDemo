package mo.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mo.entity.Student;
import mo.service.StudentService;


public class UpdateStuByNoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UpdateStuByNoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

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
		int StuAge=Integer.parseInt(request.getParameter("StuAge"));
		String gName=request.getParameter("gName");
//		封装到实体类
		Student stu=new Student(StuNo,StuName,StuAge,gName);
		System.out.print(stu+"来自updateServlet");
//		调用逻辑层代码修改学生信息
		StudentService stuservice=new StudentService();
		boolean flag=stuservice.UpdateStuByNo(stu,StuNo);
		if(!flag){
			System.out.println("修改失败");
			request.setAttribute("stu", stu);
			request.getRequestDispatcher("update.jsp").forward(request,response);
		}else {
			request.setAttribute("stu", stu);
			System.out.println("修改成功");
//			返回页面，因为需要传递request作用域数据，所以使用请求转发
//			request.getRequestDispatcher("fail.jsp").forward(request, response);
			request.getRequestDispatcher("QuerAllStudentServlet").forward(request, response);
		}
		
		
	}

}
