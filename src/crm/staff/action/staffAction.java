package crm.staff.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Set;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import crm.dep.domain.CrmDepartment;
import crm.domain.pageBean;
import crm.post.domain.CrmPost;
import crm.staff.domain.CrmStaff;
import crm.staff.service.Service;

public class staffAction extends ActionSupport implements ModelDriven<CrmStaff> {

	private static final long serialVersionUID = 1L;
	private CrmStaff cs = new CrmStaff();
	private Service serviceSta;
	private List<CrmStaff> css;
	private List<CrmPost> cps;
	private List<CrmDepartment> cds;
	private Set<CrmPost> crmPosts;
	private int currpage = 1;
	private String isSearch;
	private pageBean pb;

	@Override
	public CrmStaff getModel() {
		// TODO Auto-generated method stub
		return cs;
	}

	public String findall() {
		
		int pagesize = 4;
		cds = serviceSta.findcds();

		HttpSession session = ServletActionContext.getRequest().getSession();

		if ("true".equals(isSearch)) {
			session.removeAttribute("staff");
			session.setAttribute("staff", cs);
		} else if ("false".equals(isSearch)) {// 点员工管理
			session.removeAttribute("staff");
		} else {// 点页码，携带条件进行分页
			cs = (CrmStaff) session.getAttribute("staff");
		}

		pb = serviceSta.searchbypage(cs, currpage, pagesize);
		css = pb.getCss();
		return "findall";
	}

	public String predit() {
		// 员工列表
		cs = serviceSta.findbyid(cs.getStaffId());
		// 部门列表
		cds = serviceSta.findcds();
		// 职务列表
		crmPosts = serviceSta.findinnerbyid(cs.getCrmPost().getCrmDepartment().getDepId()).getCrmPosts();
		return "predit";
	}

	public String update() {
		System.out.println(cs);
		serviceSta.update(cs);
		return "update";
	}

	public String preaddstaff() {
		// 职务列表
		cps = serviceSta.findcps();
		// 部门列表
		cds = serviceSta.findcds();
		return "preaddstaff";
	}

	public String addstaff() {
		serviceSta.addstaff(cs);
		return "addstaff";
	}

public String changepostId() {
		Set<CrmPost> Posts = serviceSta.findinnerbyid(cs.getCrmPost().getCrmDepartment().getDepId()).getCrmPosts();
		Gson gson = new GsonBuilder().setExclusionStrategies(new ExclusionStrategy() {
			@Override
			public boolean shouldSkipField(FieldAttributes arg0) {
				// TODO Auto-generated method stub
				if ("crmStaffs".equals(arg0.getName()))
					return true;
				return false;
			}

			@Override
			public boolean shouldSkipClass(Class<?> arg0) {
				// TODO Auto-generated method stub
				if (CrmDepartment.class == arg0)
					return true;
				return false;
			}
		}).create();

		String json = gson.toJson(Posts);

		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/json;charset=utf-8");
		try {
			PrintWriter out = response.getWriter();
			out.write(json);
			out.flush();
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return NONE;
	}

	/*
	 * public String search() { int pagesize = 4; HttpSession session =
	 * ServletActionContext.getRequest().getSession(); //高级查询
	 * if("true".equals(isSearch)){ session.removeAttribute("staff");
	 * session.setAttribute("staff", cs); pb = serviceSta.searchbypage(cs,
	 * currpage, pagesize); css = pb.getCss(); cds = serviceSta.findcds(); }else
	 * if("false".equals(isSearch)){//点员工管理 session.removeAttribute("staff"); }
	 * else{//点页码，携带条件进行分页 cs = (CrmStaff) session.getAttribute("staff");
	 * findall(); } return "search"; }
	 */

	public CrmStaff getCs() {
		return cs;
	}

	public void setCs(CrmStaff cs) {
		this.cs = cs;
	}

	public List<CrmStaff> getCss() {
		return css;
	}

	public void setCss(List<CrmStaff> css) {
		this.css = css;
	}

	public Service getServiceSta() {
		return serviceSta;
	}

	public void setServiceSta(Service serviceSta) {
		this.serviceSta = serviceSta;
	}

	public List<CrmPost> getCps() {
		return cps;
	}

	public void setCps(List<CrmPost> cps) {
		this.cps = cps;
	}

	public List<CrmDepartment> getCds() {
		return cds;
	}

	public void setCds(List<CrmDepartment> cds) {
		this.cds = cds;
	}

	public Set<CrmPost> getCrmPosts() {
		return crmPosts;
	}

	public void setCrmPosts(Set<CrmPost> crmPosts) {
		this.crmPosts = crmPosts;
	}

	public pageBean getPb() {
		return pb;
	}

	public void setPb(pageBean pb) {
		this.pb = pb;
	}

	public String getIsSearch() {
		return isSearch;
	}

	public void setIsSearch(String isSearch) {
		this.isSearch = isSearch;
	}

	public int getCurrpage() {
		return currpage;
	}

	public void setCurrpage(int currpage) {
		this.currpage = currpage;
	}

}
