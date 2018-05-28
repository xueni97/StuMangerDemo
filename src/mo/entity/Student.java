package mo.entity;

public class Student {
	//学号
	private int StuNo;
	//	姓名
	private String StuName;
	//	年龄
	private int StuAge;
	//	年级
	private String gName;
	public int getStuNo() {
		return StuNo;
	}
	public void setStuNo(int stuNo) {
		this.StuNo = stuNo;
	}
	public String getStuName() {
		return StuName;
	}
	public void setStuName(String stuName) {
		this.StuName = stuName;
	}
	public int getStuAge() {
		return StuAge;
	}
	public void setStuAge(int stuAge) {
		this.StuAge = stuAge;
	}
	public String getgName() {
		return gName;
	}
	public void setgName(String gName) {
		this.gName = gName;
	}
	public Student(int stuNo, String stuName, int stuAge, String gName) {
		super();
		this.StuNo = stuNo;
		this.StuName = stuName;
		this.StuAge = stuAge;
		this.gName = gName;
	}
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Student [StuNo=" + StuNo + ", StuName=" + StuName + ", StuAge=" + StuAge + ", gName=" + gName + "]";
	}

	
	
	



}
