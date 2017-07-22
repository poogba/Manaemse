package crm.staff.service;

import java.util.List;

import crm.dep.domain.CrmDepartment;
import crm.domain.pageBean;
import crm.post.domain.CrmPost;
import crm.staff.domain.CrmStaff;

public interface Service {

	List<CrmStaff> findall();

	CrmStaff findbyid(String staffId);

	List<CrmPost> findcps();

	List<CrmDepartment> findcds();

	void update(CrmStaff cs);

	void addstaff(CrmStaff cs);

	CrmDepartment findinnerbyid(String depId);

	void findcd(String depId);

	/*List<CrmStaff> search(CrmStaff cs);*/

	pageBean searchbypage(CrmStaff cs, int currentpage, int pagesize);

	pageBean searchbypage(int currentpage, int pagesize);

}
