package mo.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mo.entity.User;
import mo.service.UserService;





public class LoginServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
//		接受表单数据
		
		String uname=request.getParameter("uname");
		
		String upwd=request.getParameter("upwd");
//		将数据封装到实体类
		User user=new User(uname,upwd);
		
//		调用业务逻辑层代码
		UserService uservice=new UserService();
//		通过username去查找用户
		User user2=uservice.finduserByUsername(uname);
		
				if(upwd.equalsIgnoreCase(user2.getUpwd())) {
			System.out.println("登陆成功");
//			显示全部学生信息
//			request.getRequestDispatcher("AddStudent.jsp").forward(request, response);
			request.getRequestDispatcher("QuerAllStudentServlet").forward(request, response);
			}else {
			response.sendRedirect("login.jsp");
		
	}
		}
			}

