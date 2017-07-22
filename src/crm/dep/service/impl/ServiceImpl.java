package crm.dep.service.impl;

import java.util.List;
import crm.dep.dao.Dao;
import crm.dep.domain.CrmDepartment;
import crm.dep.service.Service;

public class ServiceImpl implements Service {
	
	private Dao dao;
	
	public Dao getDao() {
		return dao;
	}
	public void setDao(Dao dao) {
		this.dao = dao;
	}


	@Override
	public void addDep(CrmDepartment cd) {
		// TODO Auto-generated method stub
		dao.addDep(cd);
	}


	@Override
	public List<CrmDepartment> findall() {
		List<CrmDepartment> list= dao.findall();
		return list;
	}
	@Override
	public CrmDepartment findbyid(String depId) {
		// TODO Auto-generated method stub

		return dao.findbyid(depId);
		
	}
	@Override
	public void edit(CrmDepartment cd) {
		// TODO Auto-generated method stub
		dao.saveEdit(cd);
	}


}
