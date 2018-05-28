package mo.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mo.entity.Student;
import mo.service.StudentService;

public class findStudentByStuNoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public findStudentByStuNoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
//		接受表单数据
		int Stuno=Integer.parseInt(request.getParameter("StuNo"));
		StudentService stuservice=new StudentService();
		Student stu=stuservice.findStudentByStuNo(Stuno);
		if(stu!=null) {
			System.out.println("返回对象成功。");
			request.setAttribute("stu", stu);
			System.out.println(stu);
			request.getRequestDispatcher("update.jsp").forward(request, response);
//			response.sendRedirect("update.jsp");
		}else {
			System.out.println("返回对象失败！");
			response.sendRedirect("update.jsp");
			//request.getRequestDispatcher("QuerAllStudentServlet").forward(request, response);
		}
	}

}
