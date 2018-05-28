package mo.servlet;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.org.apache.xml.internal.security.exceptions.Base64DecodingException;
import com.sun.org.apache.xml.internal.security.utils.Base64;

public class DownLoadFileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public DownLoadFileServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	this.doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String FileName=request.getParameter("fileName");
		//设置两个响应头文件
		response.setHeader("Content-Type" ,"application/octet-stream");
		response.setHeader("Content-Disposition", "attachment;filename"+FileName);
//		if(request.getHeader("user-agant").contains("Firefox")) {
//			//huohu
//			
//			try {
//				response.addHeader("Content-Disposition", "attachment;filename="+"?UTF-8?B?"
//				+(new String(Base64.decode(FileName.getBytes("utf-8"))))
//				+	"?="	);
//			} catch (Base64DecodingException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			
//		}else {
//			//ie
//			response.addHeader("Content-Disposition", "attachment;filename="+URLEncoder.encode(FileName,"utf-8"));
//		}
		//获取输入流
		InputStream is=getServletContext().getResourceAsStream("/upload/"+FileName);
//		InputStream is=new FileInputStream("C:\\Users\\yuqing\\Desktop\\上机实验\\"+FileName);
		//获取输出流
		OutputStream os=response.getOutputStream();
		//sql查询图片路径
		//获取磁盘文件
		byte[] buffer=new byte[1024];
		int length=-1;
		while((length=is.read(buffer))!=-1) {
			os.write(buffer,0,length);
			
		}
		os.close();
		is.close();
	}

}
