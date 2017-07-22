package crm.domain;

import java.util.List;
import crm.staff.domain.CrmStaff;

public class pageBean {

	private int totalpage;
	private int pagesize;
	private int count;
	private int currpage;
	private List<CrmStaff> css;

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

	public List<CrmStaff> getCss() {
		return css;
	}

	public void setCss(List<CrmStaff> css) {
		this.css = css;
	}

	public int getPagesize() {
		return pagesize;
	}

	public void setPagesize(int pagesize) {
		this.pagesize = pagesize;
	}

}
