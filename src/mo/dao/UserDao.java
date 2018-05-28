package mo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import mo.entity.User;


public class UserDao {

	public User finduserByUsername(String uname) {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		User user=new User();
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn =DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","scott", "tiger");
			//conn=DriverManager.getConnection(StudentDao.URL, StudentDao.USERNAME, StudentDao.PASSWORD);
			String sql="select * from userinfo where uname=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, uname);
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				String username=rs.getString(1);
				String userpwd=rs.getString(2);
			user.setUname(username);
			user.setUpwd(userpwd);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}

}
