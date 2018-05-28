package mo.entity;

import java.util.List;



public class Page {
// 总页数
	private int totalPage;
//	总数据
private int totalCount;
//	页面大小
private int pageSize;

//	当前页页码

private int correntPage;

public Page() {
	super();
	// TODO Auto-generated constructor stub
}



//	学生集合
private List<Student> Student;
	public Page(int totalPage, int totalCount, int pageSize, int correntPage) {
		super();
		this.totalPage = totalPage;
		this.totalCount = totalCount;
		this.pageSize = pageSize;
		this.correntPage = correntPage;
	}



public int getTotalPage() {
	return totalPage;
}



public int getTotalCount() {
	return totalCount;
}

public void setTotalCount(int totalCount) {
	this.totalCount = totalCount;
	totalPage=this.totalCount%pageSize==0?(this.totalCount/pageSize):this.totalCount/pageSize+1;
}

public int getPageSize() {
	return pageSize;
}

public void setPageSize(int pageSize) {
	this.pageSize = pageSize;
}

public int getCorrentPage() {
	return correntPage;
}

public void setCorrentPage(int correntPage) {
	this.correntPage = correntPage;
}



@Override
public String toString() {
	return "Page [totalPage=" + totalPage + ", totalCount=" + totalCount + ", pageSize=" + pageSize + ", correntPage="
			+ correntPage + "]";
}
}
