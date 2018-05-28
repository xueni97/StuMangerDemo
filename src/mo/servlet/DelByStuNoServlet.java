package mo.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mo.entity.Student;
import mo.service.StudentService;


/**
 * Servlet implementation class DelByStuNoServlet
 */
public class DelByStuNoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DelByStuNoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
//		接受表单数据
		int Stuno=Integer.parseInt(request.getParameter("StuNo"));
//		调用业务逻辑层
		StudentService stuservice=new StudentService();
		boolean flag=stuservice.DelByStuNo(Stuno);
		if(flag) {
			System.out.println("删除成功");
			request.getRequestDispatcher("QuerAllStudentServlet").forward(request,response);
		}else {
			System.out.println("删除失败");
//			如果失败在request放入标识符，表示错误
			request.setAttribute("addError", "error");
//			返回页面，因为需要传递request作用域数据，所以使用请求转发
//			request.getRequestDispatcher("fail.jsp").forward(request, response);
			request.getRequestDispatcher("fail.jsp").forward(request, response);
		}
	
}
}

