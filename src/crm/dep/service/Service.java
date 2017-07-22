package crm.dep.service;

import java.util.List;

import crm.dep.domain.CrmDepartment;

public interface Service {
	
	void addDep(CrmDepartment cd);

	List<CrmDepartment> findall();

	CrmDepartment findbyid(String depId);

	void edit(CrmDepartment cd);
	
}