package crm.post.action;

import java.util.List;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import crm.dep.domain.CrmDepartment;
import crm.post.domain.CrmPost;
import crm.post.service.Service;

public class postAction extends ActionSupport implements ModelDriven<CrmPost > {

	private static final long serialVersionUID = 1L;
	
	private CrmPost cp = new CrmPost();
	
	private Service servicePost;
	
	private List<CrmPost> cps;
	
	private List<CrmDepartment> cds;

	@Override
	public CrmPost getModel() {
		// TODO Auto-generated method stub
		return cp;
	}
	
	
	public String findall(){
		cps=servicePost.findall();
		return "findall";
	}
	
	public String findbyid(){
		cds=servicePost.findcds();
		cp = servicePost.findbyid(cp.getPostId());
		return "findbyid";
		
	}
	
	public String preadd(){
		cds=servicePost.findcds();
		return "preadd";
	}
	
	
	public String addpost(){
		System.out.println(cp);
		servicePost.addpost(cp);
		return "addpost";
	}
	
	public String update(){
		System.out.println(cp);
		servicePost.update(cp);
		return "update";
	}
	

	public CrmPost getCp() {
		return cp;
	}

	public void setCp(CrmPost cp) {
		this.cp = cp;
	}


	public List<CrmPost> getCps() {
		return cps;
	}


	public void setCps(List<CrmPost> cps) {
		this.cps = cps;
	}


	public Service getServicePost() {
		return servicePost;
	}


	public void setServicePost(Service servicePost) {
		this.servicePost = servicePost;
	}


	public List<CrmDepartment> getCds() {
		return cds;
	}


	public void setCds(List<CrmDepartment> cds) {
		this.cds = cds;
	}

}
