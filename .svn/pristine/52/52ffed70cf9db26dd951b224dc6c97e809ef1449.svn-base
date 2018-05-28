package mo.dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;


public class DBUtil {
	public static final String DRIVER="oracle.jdbc.OracleDriver";
	public static final String URL="jdbc:oracle:thin:@localhost:1521:orcl";
	public static final String USERNAME="scott";
	public static final String PASSWORD="tiger";
	 public static Connection conn=null;
	 public static PreparedStatement pstmt=null;
	 public static ResultSet rs=null;
	 private static Context ctx = null; 
	 private static DataSource ds = null ; 
	 public static Statement stmt=null;
	 // 通用的，获取数据源DataSource对象的方法
	 public static DataSource getDataSource() {
	  try{
	   ctx = new InitialContext();
	   ds=(DataSource)ctx.lookup("java:comp/env/student");
	  }catch(NamingException e){
	   e.printStackTrace();
	  }catch(Exception e){
	   e.printStackTrace();
	  }
	   return ds ; 
	 }
	 // 通用的，根据数据源获取Statement对象的方法
	 public static Statement createStatement(){
	  try{
	  conn=getDataSource().getConnection();  
	  stmt = conn.createStatement();
	  }catch(SQLException e){
	   e.printStackTrace();
	  } catch(Exception e){
	   e.printStackTrace();
	  }
	  return stmt;
	 }
    // 通用的，获取数据库连接对象的方法
 public static Connection getConnection() {
	
  try{
   Class.forName(DRIVER);
   conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
  }
  catch (ClassNotFoundException e)
  {
   e.printStackTrace();
  }
  catch (SQLException e)
  {
   e.printStackTrace();
  }
  catch (Exception e)
  {
   e.printStackTrace();
  }
  return conn;
 }
 // 通用的，获取PreparedStatement对象的方法
 public static PreparedStatement createPreparedStatement(String sql,Object[] os)  {
  try{
   pstmt = getConnection().prepareStatement(sql);
   if (os != null){
    for (int i = 0; i < os.length; i++)
   {
     pstmt.setObject(i + 1, os[i]);
    }
   }
  }
  catch (SQLException e){
   e.printStackTrace();
  }
  catch (Exception e){
   e.printStackTrace();
  }
  return pstmt; 
  }
 public static int getTotalcount(String sql) {
	 int totalCount=0;
	 ResultSet rs=null;
	 try {
		 pstmt=createPreparedStatement(sql, null);
		rs=pstmt.executeQuery();
		while(rs.next()) {
			totalCount=rs.getInt(1);
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally {
		closeAll(rs, pstmt, conn);
	}
	 return totalCount;
 }
 // 通用的，关闭访问数据库相关对象的方法(注意PreparedStatement继承自Statement)
 public static void closeAll(ResultSet rs,PreparedStatement pstmt,Connection conn )
 {
  try
  {
   if (conn != null)
    conn.close();
   if (pstmt != null)
    pstmt.close();
   if (conn != null)
    conn.close();
  }
  catch (SQLException e)
  {
   e.printStackTrace();
  }
 }
 // 通用的增加、删除、修改方法
 public static boolean executeAddOrUpdateOrDelete(String sql ,Object[] os){
  // flag用来标记是否增加成功，若增加成功则返回true，若增加失败则返回false
  boolean flag = true;
  try
  {
   // 获取Statement对象
   pstmt = createPreparedStatement(sql,os);
   int rs=pstmt.executeUpdate();
   System.out.println(rs+"来自dbutil");
  }
  catch (Exception e)
  {
   e.printStackTrace();
   flag = false;
  }
  finally
  {
   closeAll(null, pstmt, conn);
  }
  return flag;
 }
 // 通用的查询方法，返回查询的结果集ResultSet对象
 public static ResultSet executeQuery(String sql, Object[] os) 
{
  ResultSet rs = null; 
  try 
{
   pstmt = createPreparedStatement(sql,os);
   rs = pstmt.executeQuery();
  } catch (SQLException e) 
{
   System.out.println("SQLException：" + e);
  }catch (Exception e) 
{
   System.out.println("查询发生异常：" + e);
  }
  return rs;
}
}
