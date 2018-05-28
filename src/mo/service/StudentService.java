package mo.service;


import java.util.List;

import mo.dao.StudentDao;
import mo.entity.Student;


public class StudentService {
 //业务逻辑层依赖数据访问层
	StudentDao stuDao=new StudentDao();
	//增加学生
	public boolean AddStudent(Student stu){
//		增加前进行逻辑判断，如果此人存在，则不增加
		if(stuDao.isExistByNo(stu.getStuNo())) {
			System.out.println("此人已存在");
			return false;
		}else {
			
			return stuDao.AddStudent(stu);
		}
	}
//	根据学号查找信息
	public Student findStudentByStuNo(int Stuno) {
		
		System.out.println("SERVICE中");
		return stuDao.findStudentByStuNo(Stuno);
	}
//	根据学号判断一个人是否存在
	public boolean isExistByNo(int StuNo) {
		return stuDao.isExistByNo(StuNo);
	}
//	根据学号修改学生信息
	public boolean UpdateStuByNo(Student stu, int stuNo) {
		
		return stuDao.UpdateStuByNo(stu, stuNo);
	}
	//查询全部学生信息
		public List<Student> QueryAllStudents(){
//			StudentDao dao = new StudentDao();
			return stuDao.findAllStudents();		

		}
		public boolean DelByStuNo(int Stuno) {
			// TODO Auto-generated method stub
//			业务逻辑层依赖于数据访问层
			StudentDao studao=new StudentDao();
			
			return studao.DeleteStudent(Stuno);
		}
}
