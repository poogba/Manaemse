package crm.course.domain;

import java.util.List;

public class pageBean {

	private int totalpage;
	private int pagesize;
	private int count;
	private int currpage;
	private List<CrmCourseType> ccts;

	public int getTotalpage() {
		return totalpage;
	}

	public void setTotalpage(int totalpage) {
		this.totalpage = totalpage;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getCurrpage() {
		return currpage;
	}

	public void setCurrpage(int currpage) {
		this.currpage = currpage;
	}

	public int getPagesize() {
		return pagesize;
	}

	public void setPagesize(int pagesize) {
		this.pagesize = pagesize;
	}

	public List<CrmCourseType> getCcts() {
		return ccts;
	}

	public void setCcts(List<CrmCourseType> ccts) {
		this.ccts = ccts;
	}

	@Override
	public String toString() {
		return "pageBean [totalpage=" + totalpage + ", pagesize=" + pagesize + ", count=" + count + ", currpage="
				+ currpage + ", ccts=" + ccts + "]";
	}

}
