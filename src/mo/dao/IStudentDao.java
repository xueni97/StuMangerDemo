package mo.dao;

import java.util.List;

import mo.entity.Student;



public interface IStudentDao {
//	h获取数据总数
	public int getTotalcount();
//	获取当前页面学生集合根据当前页面，和页面大小
	public List<Student> getCurrentPageStuList(int currentPage,int pagesize);
	
}
