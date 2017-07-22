package crm.course.action;

import java.util.List;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import crm.course.domain.CrmCourseType;
import crm.course.domain.pageBean;
import crm.course.service.Service;

public class courseAction extends ActionSupport implements ModelDriven<CrmCourseType> {

	private static final long serialVersionUID = 1L;

	private CrmCourseType cct = new CrmCourseType();

	private Service serviceCrs;

	private List<CrmCourseType> ccts;

	private String isSearch;

	private pageBean pb;

	private int currpage=1;

	private int TS;
	private int TE;
	private double LCS;
	private double LCE;

	@Override
	public CrmCourseType getModel() {
		// TODO Auto-generated method stub
		return cct;
	}

	public String findall() {

		int pagesize = 4;

		/*ccts = serviceCrs.findall();*/
		
		
		System.out.println("++++++++++++++++++++");
		System.out.println(cct);
		System.out.println("---"+TS+"---"+TE+"---"+LCS+"---"+LCE);
		System.out.println("++++++++++++++++++++");

		HttpSession session = ServletActionContext.getRequest().getSession();

		if ("true".equals(getIsSearch())) {
			session.removeAttribute("cct");
			session.setAttribute("cct", cct);
		} else if ("false".equals(getIsSearch())) {// 点员工管理
			session.removeAttribute("cct");
		} else {// 点页码，携带条件进行分页
			cct = (CrmCourseType) session.getAttribute("cct");
		}

		pb = serviceCrs.searchbypage(cct,currpage,pagesize,TS,TE,LCS,LCE);

		/*
		 * HttpSession session = ServletActionContext.getRequest().getSession();
		 * 
		 * if ("true".equals(isSearch)) { session.removeAttribute("staff");
		 * session.setAttribute("staff", cs); } else if
		 * ("false".equals(isSearch)) {// 点员工管理
		 * session.removeAttribute("staff"); } else {// 点页码，携带条件进行分页 cs =
		 * (CrmStaff) session.getAttribute("staff"); }
		 * 
		 * pb = serviceSta.searchbypage(cs, currpage, pagesize); css =
		 * pb.getCss(); return "findall";
		 */
		
		ccts = pb.getCcts();

		return "findall";
	}

	public String add() {

		serviceCrs.add(cct);
		return "add";
	}

	public String predit() {

		cct = serviceCrs.findbyid(cct.getCourseTypeId());
		return "predit";
	}

	public String update() {

		serviceCrs.update(cct);
		return "update";
	}

	public CrmCourseType getCct() {
		return cct;
	}

	public void setCct(CrmCourseType cct) {
		this.cct = cct;
	}

	public Service getServiceCrs() {
		return serviceCrs;
	}

	public void setServiceCrs(Service serviceCrs) {
		this.serviceCrs = serviceCrs;
	}

	public List<CrmCourseType> getCcts() {
		return ccts;
	}

	public void setCcts(List<CrmCourseType> ccts) {
		this.ccts = ccts;
	}

	public String getIsSearch() {
		return isSearch;
	}

	public void setIsSearch(String isSearch) {
		this.isSearch = isSearch;
	}

	public pageBean getPb() {
		return pb;
	}

	public void setPb(pageBean pb) {
		this.pb = pb;
	}

	public int getCurrpage() {
		return currpage;
	}

	public void setCurrpage(int currpage) {
		this.currpage = currpage;
	}

	public int getTS() {
		return TS;
	}

	public void setTS(int tS) {
		TS = tS;
	}

	public int getTE() {
		return TE;
	}

	public void setTE(int tE) {
		TE = tE;
	}

	public double getLCS() {
		return LCS;
	}

	public void setLCS(double lCS) {
		LCS = lCS;
	}

	public double getLCE() {
		return LCE;
	}

	public void setLCE(double lCE) {
		LCE = lCE;
	}

}
