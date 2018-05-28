package mo.servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;

public class AddStuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String StuNo = null;
	private static final FileItemFactory factory = null;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		使用out.printf()之前，应先使用setcontenttype（）方法设置编码；
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		File file=new File("F:\\Workspaces");
		PrintWriter out=response.getWriter();
//		上传文件名
		String uploadFileName="";
//		表单字段name属性值
		String filedName="";
		boolean isMultipart=ServletFileUpload.isMultipartContent(request);
		  // 上传文件的存储路径（Web应用在tomcat部署路径中的upload目录，）
//		  String uploadFilePath = request.getSession().getServletContext().getRealPath("upload/");
		  if (isMultipart) {
			 DiskFileItemFactory factory=new DiskFileItemFactory();
//		   FileItemFactory factory = new DiskFileItemFactory();
		   // 通过FileItemFactory对象，产生ServletFileUpload对象
		   ServletFileUpload upload = new ServletFileUpload(factory);
		   factory.setSizeThreshold(102400);
		   factory.setRepository(file);
		   upload.setFileSizeMax(204800);
		    // 保存学生信息的属性值
		    try {
				int studentNo = -1;
				String studentName = null;
				int studentAge = -1;
				String gradeName = null;
				// 解析form表单中所有字段元素
				List<FileItem> items = upload.parseRequest(request);
				// 遍历form表单的每一个字段元素
				Iterator<FileItem> iter = items.iterator();
				  while (iter.hasNext()){
					     FileItem item = (FileItem) iter.next();
					     // 如果是普通表单字段
					     if (item.isFormField()) {
					      // 获取表单字段的name属性值
					      filedName = item.getFieldName();
					      // 依次处理每一个字段
					      if (filedName.equals("StuNo")) {
					       String StuNo = item.getString("UTF-8");
					       studentNo = Integer.parseInt(StuNo);
					      }
					      else if (filedName.equals("StuName")){
					       studentName = item.getString("UTF-8");
					      }else if (filedName.equals("StuAge")) {
					       String StuAge = item.getString("UTF-8");
					       studentAge = Integer.parseInt(StuAge);
					      }else if (filedName.equals("gName")){
					       gradeName = item.getString("UTF-8");
					      }
					     }else {
					     // 文件表单字段 
					     
					      try {
					    	  // 获取正在上传的文件名 
							String fileName = item.getName();
							//获取后缀名
							String ext=fileName.substring(fileName.lastIndexOf(".")+1);
							  if (fileName != null && !fileName.equals("")&&ext.equals("jpg")||ext.equals("bmp")){
								  
								  String uploadFilePath="C:\\Users\\yuqing\\Desktop\\上机实验";
//									  File file=new File("F:\\WorkFspaces",fileName); 
							   File file2= new File(uploadFilePath, fileName);
									  item.write(file2);
									  out.println("增加学生信息及图片上传成功！");
									  out.println();
							          
							  }else {
								  out.print("操作失败");
								  return ;
							  }
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					     }
					  }
			} catch (FileUploadException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		  
		   } 
	}
}
		     
		     
		  