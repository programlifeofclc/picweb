package utils;

import java.util.List;

public class EasyUIPage {
	private int pageNumber = 1;//当前页数
	private int pageSize = 10;//每页条数
	private int total = 0;//总条数
	private List<?> rows;
	
	public EasyUIPage(int pageNumber,int pageSize,int counts,List<?> rows){
		this.pageNumber = pageNumber;
		this.pageSize = pageSize;
		this.total = counts;
		this.rows = rows;
	}

	public int getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public List<?> getRows() {
		return rows;
	}

	public void setRows(List<?> rows) {
		this.rows = rows;
	}
	
}
