package mo.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mo.entity.Student;
import mo.service.StudentService;




@WebServlet("/QuerAllStudentServlet")
public class QuerAllStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		//查询全部学生信息
				StudentService service = new StudentService();
				List<Student> stus = service.QueryAllStudents();
				request.setAttribute("stus", stus);
				request.getRequestDispatcher("showAll.jsp").forward(request, response);
	}

}
