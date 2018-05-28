package mo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import mo.dbutil.DBUtil;
import mo.entity.Student; 

public class StudentDao implements IStudentDao{
public static final String DRIVER="oracle.jdbc.OracleDriver";
public static final String URL="jdbc:oracle:thin:@localhost:1521:orcl";
public static final String USERNAME="scott";
public static final String PASSWORD="tiger";
//增加
public boolean AddStudent(Student stu) {
//	 输入语句
			String sql = "insert into student(stuNo,stuName,stuAge,gName) values(?,?,?,?)";
//	获得对象
			Object[] os ={ stu.getStuNo(), stu.getStuName(),
			stu.getStuAge(), stu.getgName() };
//			到辅助包，执行语句，返回执行结果trure false
	  return DBUtil.executeAddOrUpdateOrDelete(sql, os);
	
//		try {
//			
//			Class.forName(DRIVER);
//			conn=DriverManager.getConnection(URL, USERNAME, PASSWORD);
//			String sql="insert into student(StuNo,StuName,StuAge,gName) values(?,?,?,?)";
//			pstmt=conn.prepareStatement(sql);
//			pstmt.setInt(1, stu.getStuNo());
//			pstmt.setString(2, stu.getStuName());
//			pstmt.setInt(3, stu.getStuAge());
//			pstmt.setString(4, stu.getgName());
//			result=pstmt.executeUpdate();
//			if(result>0) {
//				System.out.println("增加成功");
//				return true;
//			}else {
//				System.out.println("增加失败");
//				return false;
//			}
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
////		<%
////			Student stu = (Student)request.getAttribute("stu");
////			%>
//			e.printStackTrace();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return false;
//}
	}
//	判断学生是否存在
		public boolean isExistByNo(int StuNo) {
			if(findStudentByStuNo(StuNo)==null) {
				System.out.println("学生不存在");
				return false;
			}else {
				System.out.println("学生存在");
				return true;
			}
		}

public Student findStudentByStuNo(int Stuno) {
	// TODO Auto-generated method stub
//	输入语句
	String sql="select * from Student where StuNo=?";
//	获取对象
	Object[] os= {Stuno	};
	
	ResultSet s=DBUtil.executeQuery(sql, os);
	try {
		while(s.next()) {
			int StuNo=s.getInt(1);
			String StuName=s.getString(2);
			int StuAge=s.getInt(3);
			String gName=s.getString(4);
			Student stu=new Student();
			stu.setStuNo(StuNo);
			stu.setStuName(StuName);
			stu.setStuAge(StuAge);
			stu.setgName(gName);
			System.out.println(stu);
			return stu;
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return null;
//	Connection conn=null;
//	PreparedStatement pstmt=null;
//	try {
//		Class.forName(DRIVER);
//		conn=DriverManager.getConnection(URL, USERNAME, PASSWORD);
//		ResultSet s=null;
//		String sql="select * from Student where StuNo=?";
//		pstmt=conn.prepareStatement(sql);
//		pstmt.setInt(1, Stuno);
//		s=pstmt.executeQuery();
//		while(s.next()) {
//			int StuNo=s.getInt(1);
//			String StuName=s.getString(2);
//			int StuAge=s.getInt(3);
//			String gName=s.getString(4);
//			Student stu=new Student();
//			stu.setStuNo(StuNo);
//			stu.setStuName(StuName);
//			stu.setStuAge(StuAge);
//			stu.setgName(gName);
//			System.out.println(stu);
//			return stu;
//		}
//	} catch (ClassNotFoundException | SQLException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
//	return null;

}
//查询全部学生
	public List<Student> findAllStudents(){
		String sql="select stuno,stuname,stuage,gname from Student";
		Object[] os=null;
		List<Student> list=new ArrayList<Student>();
		ResultSet rs=DBUtil.executeQuery(sql, os);
		try {
			while(rs.next()) {
				int StuNo=rs.getInt(1);
				String StuName=rs.getString(2);
				int StuAge=rs.getInt(3);
				String gName=rs.getString(4);
				Student stu=new Student(StuNo,StuName,StuAge,gName);
				list.add(stu);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.closeAll(rs, null, null);
		}
		return list;
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//		List<Student> list = new ArrayList<Student>();
//			try {
//				Class.forName(DRIVER);
//				conn= DriverManager.getConnection(URL,USERNAME,PASSWORD);
//				System.out.println(conn);
//				String sql = "select * from Student";
//				pstmt = conn.prepareStatement(sql);
//				rs = pstmt.executeQuery();
//				while(rs.next()) {
//					int stuNo = rs.getInt(1);
//					String stuName = rs.getString(2);
//					int stuAge = rs.getInt(3);
//					String gName = rs.getString(4);
//					Student stu = new Student(stuNo,stuName,stuAge,gName);
//					list.add(stu);
//					
//				}
//				return list;
//				
//			} catch (ClassNotFoundException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}finally {
//				try {
//					if(rs != null) {
//						rs.close();
//					}
//					if(pstmt != null) {
//						pstmt.close();
//					}
//					if(conn != null) {
//						conn.close();
//					}
//				} catch (SQLException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}
//		return list;
	}
//	获取数据总数
	
	// 修改学生信息:将原来学号为stuNo的学生信息，修改为实体类stu中的包含信息
	public boolean UpdateStuByNo(Student stu, int stuNo) {
		String sql="update student set stuNo = ?,stuName = ?,stuAge = ? ,gName=? where stuNo = ?";
		Object[] os= {stu.getStuNo(),stu.getStuName(),stu.getStuAge(),stu.getgName(),stu.getStuNo()};
		return DBUtil.executeAddOrUpdateOrDelete(sql, os);
//	 
//	  Connection conn = null;
//	 PreparedStatement pstmt = null;
//	  // flag用来标记是否修改成功，若修改成功则返回true，若修改失败则返回false
//	    boolean flag= true;
//	  try
//	  {
//	   Class.forName(DRIVER);
//	   conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
//	   System.out.println(conn);
//	   String sql = "update student set stuNo = ?,stuName = ?,stuAge = ? ,gName=? where stuNo = ?";
//	   pstmt = conn.prepareStatement(sql);
//	   pstmt.setInt(1, stu.getStuNo());
//	   pstmt.setString(2, stu.getStuName());
//	   pstmt.setInt(3, stu.getStuAge());
//	   pstmt.setString(4, stu.getgName());
//	   pstmt.setInt(5, stu.getStuNo());
//	   int rs=pstmt.executeUpdate();
//	   System.out.println(rs+"来自StudentDao");
//	  }
//	  catch (Exception e){
//	   e.printStackTrace();
//	   flag = false;
//	  }
//	  finally{
//	   try{
//	    if(pstmt != null)pstmt.close();
//	    if(conn != null)conn.close();
//	   }
//	   catch (SQLException e){
//	    e.printStackTrace();
//	    flag = false;
//	   }
//	  }
//	 
//	return flag;
	}
	 

//	根据学号删除学生
	
	public boolean DeleteStudent(int Stuno) {
		String sql="DELETE FROM STUDENT WHERE STUNO=?";
		Object[] os= {Stuno};
		return DBUtil.executeAddOrUpdateOrDelete(sql, os);
//		Connection conn=null;
//		PreparedStatement pstmt=null;
//		ResultSet rs=null;
//		try {
//			Class.forName(DRIVER);
//			conn=DriverManager.getConnection(URL, USERNAME, PASSWORD);
//			String sql="delete from Student where StuNo=?";
//			pstmt=conn.prepareStatement(sql);
//			pstmt.setInt(1, Stuno);
//			int result=pstmt.executeUpdate();
//			System.out.println(result);
//		
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}finally {
//			try {
//				if(rs != null) {
//					rs.close();
//				}
//				if(pstmt != null) {
//					pstmt.close();
//				}
//				if(conn != null) {
//					conn.close();
//				}
//			}
//		catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//			
//		return false;
//	}
	}
@Override
public int getTotalcount() {
	// TODO Auto-generated method stub
	return 0;
}
@Override
public List<Student> getCurrentPageStuList(int currentPage, int pagesize) {
	// TODO Auto-generated method stub
	return null;
}
	
}

