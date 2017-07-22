package crm.dep.dao;

import java.util.List;

import crm.dep.domain.CrmDepartment;

public interface Dao {
	
	void addDep(CrmDepartment cd);

	List<CrmDepartment> findall();

	CrmDepartment findbyid(String depId);

	void saveEdit(CrmDepartment cd);

}
