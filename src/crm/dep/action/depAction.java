package crm.dep.action;

import java.util.List;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import crm.dep.domain.CrmDepartment;
import crm.dep.service.Service;

public class depAction extends ActionSupport implements ModelDriven<CrmDepartment> {

	private static final long serialVersionUID = 1L;

	private CrmDepartment cd = new CrmDepartment();

	private Service serviceDep;

	private List<CrmDepartment> cds;
	


	@Override
	public CrmDepartment getModel() {
		//接口直接返回对象
		return cd;
	}

	public String add() {
		serviceDep.addDep(cd);
		return "add";
	}

	public String findall() {
		cds = getServiceDep().findall();
		return "findall";
	}
	
	public String findbyid(){
		cd=getServiceDep().findbyid(cd.getDepId());
		return "findbyid";
	}
	
	public String edit(){
		getServiceDep().edit(cd);
		return "edit";
	}

	
	public List<CrmDepartment> getCds() {
		return cds;
	}
	public void setCds(List<CrmDepartment> cds) {
		this.cds = cds;
	}

	public CrmDepartment getCd() {
		return cd;
	}

	public void setCd(CrmDepartment cd) {
		this.cd = cd;
	}

	public Service getServiceDep() {
		return serviceDep;
	}

	public void setServiceDep(Service serviceDep) {
		this.serviceDep = serviceDep;
	}
}
